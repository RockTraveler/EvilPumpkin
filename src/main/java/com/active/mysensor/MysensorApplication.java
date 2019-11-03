package com.active.mysensor;

import com.active.mysensor.untils.HttpClientUtil;
import com.active.mysensor.untils.InfoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;
import oshi.software.os.OperatingSystem;

import java.util.*;

@SpringBootApplication
@EnableScheduling
public class MysensorApplication {
	private static final Logger logger = LoggerFactory.getLogger(MysensorApplication.class);

	SystemInfo si = new SystemInfo();
	HardwareAbstractionLayer hardware = si.getHardware();
	OperatingSystem os = si.getOperatingSystem();

	private static List<Long> downloadSpeed = new ArrayList<>();

	public static void main(String[] args) {


		Map<String, String> map = new HashMap<>();
		map.put("text", InfoUtils.get("currentStatus") + ": " + InfoUtils.getHostname());
		map.put("desp", InfoUtils.getDeviceInfo());

		HttpClientUtil.doPost("https://sc.ftqq.com/SCU48981T4fb6e368a395cf49b26f8bec99fe6cbf5cb93aed4ba36.send", map);

		SpringApplication.run(MysensorApplication.class, args);


	}
	@Scheduled(cron = "0 */1 * * * ?")
	public void reportCurrentTime() {
		logger.info("Recording the network Traffic");
		recordNetworkTraffic(hardware.getNetworkIFs());
	}



	private static void recordNetworkTraffic(NetworkIF[] networkIFs) {
		StringBuilder sb = new StringBuilder();
		if (networkIFs.length == 0) {
			sb.append(" Unknown");
		}
		for (NetworkIF net : networkIFs) {
			if (net.getIPv4addr().length < 1) {
				continue;
			}
			try {
				long currentDownload=net.getBytesRecv();
				long lastDownload=0;
				if (downloadSpeed.size()>0){
					lastDownload=downloadSpeed.get(downloadSpeed.size()-1);
//					InfoUtils.getMemorySize(currentDownload-lastDownload);
					logger.info(InfoUtils.getMemorySize(currentDownload-lastDownload)+" /Min");
				}
				downloadSpeed.add(currentDownload);
//				logger.info("Download:"+currentDownload);
//				logger.info("Upload:"+net.getBytesRecv());

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}



}
