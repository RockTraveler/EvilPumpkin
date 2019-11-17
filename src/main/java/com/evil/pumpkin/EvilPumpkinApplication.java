package com.evil.pumpkin;

import com.evil.pumpkin.untils.HttpClientUtil;
import com.evil.pumpkin.untils.InfoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.StringUtils;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;
import oshi.software.os.OperatingSystem;

import java.io.*;
import java.util.*;

@SpringBootApplication
@EnableScheduling
public class EvilPumpkinApplication  {
	private static final Logger logger = LoggerFactory.getLogger(EvilPumpkinApplication.class);
	private static Map<String,List> networkTrafficeMap = new HashMap<>();
	private static List<Long> downloadPackage = new ArrayList<>();

	SystemInfo si = new SystemInfo();
	HardwareAbstractionLayer hardware = si.getHardware();
	OperatingSystem os = si.getOperatingSystem();



	public static void main(String[] args) {

		if (!StringUtils.isEmpty(getURL())){
			sendToServerChan(InfoUtils.getBootInfo(),InfoUtils.getBootSubject());
		}

		SpringApplication.run(EvilPumpkinApplication.class, args);


	}

	@Scheduled(cron = "0 0 * * *  ?")
	public static void reportEveryHoursReport() {
		logger.info("Every Hours Task: BEGIN");
		sendToServerChan(InfoUtils.getEveryHoursReport(),InfoUtils.getHourSubject());
		logger.info("Every Hours Task: END");
	}

	@Scheduled(cron = "0 0 0 * * ?")
	public static void reportAllStatus() {
		logger.info("Every Days Task: BEGIN");
		sendToServerChan(InfoUtils.getDeviceInfo(),InfoUtils.getCurrentSubject());
		logger.info("Every Days Task: END");
	}

	public static void sendToServerChan(String text,String subject) {
		try{
			String url = getURL();
			logger.info("sendToServerhChan:"+url);
			if (!StringUtils.isEmpty(url)){
				logger.info("Collecting information.......");
				Map<String, String> map = new HashMap<>();
				map.put("text", subject);
				map.put("desp", text);

				HttpClientUtil.doPost(url, map);
			}else{
				logger.info("url is null, can not send info to server chan...........");
			}

		}catch (Exception e){
			e.printStackTrace();

		}
	}


	public static String getURL(){
		try {
			InputStream in = null;
			String currentPath=System.getProperty("user.dir");
			Properties prop = new Properties();
			File file = new File(currentPath+"/application.properties");
			logger.info("Internal application property file.");
			in = new BufferedInputStream(EvilPumpkinApplication.resourceLoader("application.properties"));
			prop.load(new InputStreamReader(in,"UTF-8"));
			if (file.exists()){
				logger.info("External application property file.");
				in = new FileInputStream(file);
				prop.load(new InputStreamReader(in,"UTF-8"));
			}

			String url =prop.getProperty("serverchan.url","");
			logger.info(url);
			return url;
		}catch (Exception e){
			e.printStackTrace();
		}
		return "";
	}

	@Scheduled(cron = "0 */1 * * * ?")
	public void reportNetworkTraffic() {

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
			 	downloadPackage= getDownloadHistoryByInterfaceName(net.getDisplayName());
				long currentDownload=net.getBytesRecv();
				long lastDownload=0;
				if (downloadPackage !=null&& downloadPackage.size()>0 ){
					lastDownload=downloadPackage.get(downloadPackage.size()-1);
					logger.info(net.getDisplayName()+" : "+InfoUtils.getMemorySize( currentDownload-lastDownload)+" /Min");

				}

				if (downloadPackage!=null){
					downloadPackage.add(currentDownload);
					networkTrafficeMap.put(net.getDisplayName(),downloadPackage);
				}


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
		if (networkTrafficeMap.size()>0){
			return networkTrafficeMap.get(name);
		}

		return new ArrayList<>();
	}

	public static InputStream resourceLoader(String fileFullPath) throws IOException {
		return getInputStream(fileFullPath);
	}

	public static InputStream getInputStream(String fileFullPath) throws IOException {
		String currentPath=System.getProperty("user.dir");
		File file = new File(currentPath+File.separator+"application.properties");
		logger.info("File Path: "+file.getAbsolutePath());
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		if(file.exists()){
			return  resourceLoader.getResource("file:"+file.getAbsolutePath()).getInputStream();
		}

		return resourceLoader.getResource(fileFullPath).getInputStream();
	}

	public static File loadFile(String fileFullPath) throws IOException {
		ResourceLoader resourceLoader = new FileSystemResourceLoader();
		return resourceLoader.getResource(fileFullPath).getFile();
	}


}
