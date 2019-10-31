package com.active.mysensor.untils;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringUtils;
import oshi.SystemInfo;
import oshi.hardware.*;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;
import oshi.util.Util;

import java.io.*;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.*;

public class InfoUtils {
    private static final int LANGUAGE_SETTING = getLanguage();
    private static final String MARK=getMark();
    private static final String NEW_LINE = "    \n";
    private static final String COLON = ": ";
    private static final String H4="####";
    private static final String H5="#####";
    private static final String BOLD="**";

    public static String getDeviceInfo() {


        // Prepare to getater the information.
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hardware = si.getHardware();
        OperatingSystem os = si.getOperatingSystem();
        StringBuffer sb = new StringBuffer();

        // Part 1: Show the base information for your devices.


        sb.append("***").append(NEW_LINE);
        sb.append(H4).append(BOLD).append(get("baseInfo")).append(BOLD).append(NEW_LINE);
        sb.append(H5).append(get("hostname")).append(COLON).append(getHostname()).append(NEW_LINE);
        sb.append(H5).append(get("internetIP")).append(COLON).append(getInternetIP()).append(NEW_LINE);
        sb.append(H5).append(get("osName")).append(COLON).append(System.getProperty("os.name")).append(NEW_LINE);
        sb.append(H5).append(get("sysTime")).append(COLON).append(getFormatDate(new Date())).append(NEW_LINE);
        sb.append(H5).append(get("osBootTime")).append(COLON).append(timeStamp2Date(String.valueOf(os.getSystemBootTime()), null)).append(NEW_LINE);
        sb.append(H5).append(get("osUptime")).append(COLON).append(FormatUtil.formatElapsedSecs(os.getSystemUptime())).append(NEW_LINE);
        sb.append(H5).append(get("cpuLoad")).append(COLON).append(getProcessLoad(hardware.getProcessor())).append(NEW_LINE);
        sb.append(H5).append(get("availableMemory")).append(COLON).append(getAvailableMemory(hardware.getMemory())).append(NEW_LINE);
        sb.append(H5).append(get("cpuTemperature")).append(COLON).append(getCpuTemperture(hardware.getSensors())).append(NEW_LINE);
        sb.append(H5).append(get("fanSpeed")).append(COLON).append(getFanSpeed(hardware.getSensors())).append(NEW_LINE);
//        sb.append(H5).append(get("cpuVoltage")).append(COLON).append(getCpuVoltage(hardware.getSensors())).append(NEW_LINE);
        sb.append(H5).append(get("networkTraffic")).append(COLON).append(getNetworkTraffic(hardware.getNetworkIFs())).append(NEW_LINE);
        sb.append(H5).append(get("mark")).append(COLON).append(BOLD).append(getMark()).append(BOLD).append(NEW_LINE);
        sb.append("***").append(NEW_LINE);

        System.out.println(sb.toString());

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {

        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());
        System.out.println(timeStamp2Date(String.valueOf(System.currentTimeMillis()),null));

    }

//    private static String getMyIP() throws IOException {
//        InputStream ins = null;
//        try {
//            //https://ip.ngrok.wang/
//            URL url = new URL("http://ip.cn");
//            URLConnection con = url.openConnection();
//            ins = con.getInputStream();
//            InputStreamReader isReader = new InputStreamReader(ins, "utf-8");
//            BufferedReader bReader = new BufferedReader(isReader);
//            StringBuffer webContent = new StringBuffer();
//            String str = null;
//            while ((str = bReader.readLine()) != null) {
//                webContent.append(str);
//            }
//            int start = webContent.indexOf("<code>")+6 ;
//            int end = webContent.indexOf("</code");
//            return webContent.substring(start, end);
//        } finally {
//            if (ins != null) {
//                ins.close();
//            }
//        }
//    }


    public static String getHostname() {
        String hostname = "unknown host";
        try {
            InetAddress addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        } catch (Exception e) {
            return "unknown host";
        }
        return hostname;
    }


    public static String get(String name) {

        try {
            Field field = RowName.class.getDeclaredField(name);
            field.setAccessible(true);
            List<String> list = (List<String>) field.get(RowName.class);
            return list.get(LANGUAGE_SETTING);
        } catch (Exception e) {
            return "unknown row name";
        }
    }

    private static Integer getLanguage() {
        int languageSetting = 0;
        try {
            languageSetting = Integer.parseInt(getPropertiesValue("language"));
        } catch (Exception e) {
            return languageSetting;
        }
        return languageSetting;
    }


    public static InputStream resourceLoader(String fileFullPath) throws IOException {
        String currentPath = System.getProperty("user.dir");
        File file = new File(currentPath + File.separator + "application.properties");

        ResourceLoader resourceLoader = new DefaultResourceLoader();
        if (file.exists()) {
            return resourceLoader.getResource("file:" + file.getAbsolutePath()).getInputStream();
        }

        return resourceLoader.getResource(fileFullPath).getInputStream();
    }


    private static String getPropertiesValue(String propertyName) {
        try {
            InputStream in = new BufferedInputStream(resourceLoader("application.properties"));
            Properties prop = new Properties();
//            prop.load(in);
            BufferedReader bf = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            prop.load(bf);
            System.out.println("\n\n\n->>>>>>>>>>>>>>\n\n\n\n"+prop.getProperty(propertyName));
            return prop.getProperty(propertyName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static String getInternetIP() {
        String ip = get("internetIPException");
        try {
            HttpResponse response = HttpClientUtil.get("https://ip.ngrok.wang");
            ip = EntityUtils.toString(response.getEntity(), "utf-8");
            return ip.trim();
        } catch (Exception e) {
            return ip.trim();
        }

    }

    public static String timeStamp2Date(String seconds, String format) {
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds + "000")));
    }

    private static String getProcessLoad(CentralProcessor processor) {
//        long[] prevTicks = processor.getSystemCpuLoadTicks();
//        return String.format("%.1f%%", processor.getSystemCpuLoadBetweenTicks(prevTicks) * 100);


        long[] prevTicks = processor.getSystemCpuLoadTicks();
        Util.sleep(1000);
        long[] ticks = processor.getSystemCpuLoadTicks();
        long user = ticks[CentralProcessor.TickType.USER.getIndex()] - prevTicks[CentralProcessor.TickType.USER.getIndex()];
        long nice = ticks[CentralProcessor.TickType.NICE.getIndex()] - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
        long sys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()] - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
        long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()] - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
        long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()] - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
        long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()] - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
        long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()] - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
        long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()] - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
        return  String.format("%.1f%%", processor.getSystemCpuLoadBetweenTicks(prevTicks) * 100);
    }

    private static String getAvailableMemory(GlobalMemory memory){
//        VirtualMemory vm = memory.getVirtualMemory();
        StringBuffer sb = new StringBuffer();
        if (memory.getTotal()<1048576){
            sb.append(memory.getAvailable()/1024/1024).append(" MB").append("/");
            sb.append(memory.getTotal()/1024/1024).append(" MB");
        }else{
            System.out.println(memory.getTotal());
            double available = memory.getAvailable();
            sb.append(String.format("%.2f",available/1024/1024/1024 )).append(" GiB").append("/");
            double total=memory.getTotal();
            sb.append(String.format("%.2f",total/1024/1024/1024 )).append(" GiB");
        }
        return sb.toString();

    }

    private static String getCpuTemperture(Sensors sensors){
        if (sensors.getCpuTemperature()<0.1||sensors.getCpuTemperature()==0){
            return get("temperatureException");
        }else{
            return String.format(String.format("%.2f", sensors.getCpuTemperature()))+"℃";
        }
    }
    private static String getFanSpeed(Sensors sensors){
        StringBuffer sb = new StringBuffer();
        for (int speed: sensors.getFanSpeeds()){
            if (speed<1){
                return get("fanSpeedException");
            }else{
                sb.append(speed).append(" / ");
            }
        }
        if (sb.length()<4){
            return get("fanSpeedException");
        }
        String fanSpeed=sb.substring(0,sb.length()-2);
       return fanSpeed ;
    }
    private static String getCpuVoltage(Sensors sensors){
        if (sensors.getCpuVoltage()<0.1||sensors.getCpuVoltage()==0){
            return get("cpuVoltageException");
        }else{
            return String.valueOf(sensors.getCpuVoltage());
        }
    }
    private static String getMark(){
        String mark = get("markException");
        try {
            mark = getPropertiesValue("mark");
            if (StringUtils.isEmpty(mark) ||"null".equals(mark)){
                return get("markException");
            }
        } catch (Exception e) {
            return mark;
        }
        return mark;
    }

    private static String getNetworkTraffic(NetworkIF[] networkIFs) {
        StringBuilder sb = new StringBuilder();
        double traffic =0;
        if (networkIFs.length == 0) {
            sb.append(" Unknown");
        }
        for (NetworkIF net : networkIFs) {
           System.out.println(net.getIPv4addr().length + " : "+Arrays.toString(net.getIPv4addr()) );
            if (net.getIPv4addr().length<1){
                continue;
            }
            try {
                long download1 = net.getBytesRecv();
                Thread.sleep(2000); //Sleep for a bit longer, 2s should cover almost every possible problem
                net.updateAttributes(); //Updating network stats
                long download2 = net.getBytesRecv();
                long result = download2-download1;
                if (result>1048576){
                    traffic=result/1024/1024/2;
                    sb.append(traffic).append(" MB/s | ");
                }else{
                    traffic=result/1024/2;
                    sb.append(traffic).append(" KB/s | ");
                }

            }catch (Exception e){
                e.printStackTrace();
                return get("networkTrafficeException");
            }

        }
        String trafficResult=get("networkTrafficeException");
        if (sb.length()>5){
            trafficResult=sb.substring(0,sb.length()-2);
        }

        return trafficResult;
    }
     // return String.format(String.format("%.2f", sensors.getCpuTemperature()))+"℃";

    private static String getFormatDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
        return sdf.format(date);
    }

}
