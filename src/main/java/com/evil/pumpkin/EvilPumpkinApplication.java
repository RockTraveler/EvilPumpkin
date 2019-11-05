package com.evil.pumpkin;

import com.evil.pumpkin.untils.InfoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;
import oshi.software.os.OperatingSystem;

import java.util.*;

@SpringBootApplication
@EnableScheduling
public class EvilPumpkinApplication {
	private static final Logger logger = LoggerFactory.getLogger(EvilPumpkinApplication.class);
	private static Map<String,List> networkTrafficeMap = new HashMap<>();


	SystemInfo si = new SystemInfo();
	HardwareAbstractionLayer hardware = si.getHardware();
	OperatingSystem os = si.getOperatingSystem();




	public static void main(String[] args) {


//		Map<String, String> map = new HashMap<>();
//		map.put("text", InfoUtils.get("currentStatus") + ": " + InfoUtils.getHostname());
//		map.put("desp", InfoUtils.getDeviceInfo());
//
//		HttpClientUtil.doPost("https://sc.ftqq.com/SCU48981T4fb6e368a395cf49b26f8bec99fe6cbf5cb93aed4ba36.send", map);

		SpringApplication.run(EvilPumpkinApplication.class, args);


	}
//	@Scheduled(cron = "0 */1 * * * ?")
//	public void reportCurrentTime() {
//		logger.info("Recording the network Traffic");
//		recordNetworkTraffic(hardware.getNetworkIFs());
//	}



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
				List<Long> downloadPackage = getDownloadHistoryByInterfaceName(net.getDisplayName());
				System.out.println(net.getName());
				long currentDownload=net.getBytesRecv();
				long lastDownload=0;
				if (downloadPackage.size()>0){
					lastDownload=downloadPackage.get(downloadPackage.size()-1);
//					InfoUtils.getMemorySize(currentDownload-lastDownload);
					logger.info(net.getDisplayName()+" : "+InfoUtils.getMemorySize( currentDownload-lastDownload)+" /Min");
				}
				downloadPackage.add(currentDownload);
				networkTrafficeMap.put(net.getDisplayName(),downloadPackage);
//				logger.info("Download:"+currentDownload);
//				logger.info("Upload:"+net.getBytesRecv());

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private static long getLastDownByInterfaceName(String name){
		List<Long> downloadPackage= networkTrafficeMap.get(name);
		if (downloadPackage.size()>0){
			return downloadPackage.get(downloadPackage.size()-1);
		}
		return 0;
	}

	private static List<Long> getDownloadHistoryByInterfaceName(String name){
		return networkTrafficeMap.get(name);

	}



}
