package com.active.mysensor.untils;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringUtils;
import oshi.SystemInfo;
import oshi.hardware.*;
import oshi.software.os.FileSystem;
import oshi.software.os.NetworkParams;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;
import oshi.util.Util;

import java.io.*;
import java.lang.reflect.Field;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.*;

public class InfoUtils {
    private static final int LANGUAGE_SETTING = getLanguage();
    private static final String MARK = getMark();
    private static final String ENTER = "    \n";
    private static final String COLON = ": ";
    private static final String H4 = "####";
    private static final String H5 = "#####";
    private static final String H6 = "######";
    private static final String BOLD = "**";
    private static final String LINE = "***";
    private static final String POINT = "-";
    public static String getDeviceInfo() {


        // Prepare to getater the information.
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hardware = si.getHardware();
        OperatingSystem os = si.getOperatingSystem();
        StringBuffer sb = new StringBuffer();


        /**
         *      Base Information
         **/

        sb.append(LINE).append(ENTER);
        sb.append(H4).append(BOLD).append(get("baseInfo")).append(BOLD).append(ENTER).append(ENTER);
        sb.append(H5).append(get("hostname")).append(COLON).append(getHostname()).append(ENTER);
        sb.append(H5).append(get("internetIP")).append(COLON).append(getInternetIP()).append(ENTER);
        sb.append(H5).append(get("osName")).append(COLON).append(System.getProperty("os.name")).append(ENTER);
        sb.append(H5).append(get("sysTime")).append(COLON).append(getFormatDate(new Date())).append(ENTER);
        sb.append(H5).append(get("osBootTime")).append(COLON).append(timeStamp2Date(String.valueOf(os.getSystemBootTime()), null)).append(ENTER);
        sb.append(H5).append(get("osUptime")).append(COLON).append(FormatUtil.formatElapsedSecs(os.getSystemUptime())).append(ENTER);
        sb.append(H5).append(get("cpuLoad")).append(COLON).append(getProcessLoad(hardware.getProcessor())).append(ENTER);
        sb.append(H5).append(get("availableMemory")).append(COLON).append(getAvailableMemory(hardware.getMemory())).append(ENTER);
        sb.append(H5).append(get("cpuTemperature")).append(COLON).append(getCpuTemperture(hardware.getSensors())).append(ENTER);
        sb.append(H5).append(get("fanSpeed")).append(COLON).append(getFanSpeed(hardware.getSensors())).append(ENTER);
        sb.append(H5).append(get("networkTraffic")).append(COLON).append(getNetworkTraffic(hardware.getNetworkIFs())).append(ENTER);
        sb.append(H5).append(get("mark")).append(COLON).append(BOLD).append(getMark()).append(BOLD).append(ENTER);
        sb.append(LINE).append(ENTER);


        /**
         *      OS
         **/
        sb.append(H4).append(BOLD).append(get("osInfo")).append(BOLD).append(ENTER).append(ENTER);
        sb.append(H6).append(get("osVersion")).append(COLON).append(os.toString()).append(ENTER);
        sb.append(H6).append(get("osArch")).append(COLON).append(System.getProperty("os.arch")).append(ENTER);
        sb.append(LINE).append(ENTER);

        /**
         *      Hardware part
         **/
        //Processor
        sb.append(H4).append(BOLD).append(get("hardware")).append(BOLD).append(ENTER).append(ENTER);
        sb.append(BOLD).append(get("processor")).append(BOLD).append(ENTER);
        sb.append(H5).append(get("processor")).append(COLON).append(hardware.getProcessor().getName()).append(ENTER);
        sb.append(H5).append(get("processorPackage")).append(COLON).append(hardware.getProcessor().getPhysicalPackageCount()).append(ENTER);
        sb.append(H5).append(get("processorCore")).append(COLON).append(hardware.getProcessor().getPhysicalProcessorCount()).append(ENTER);
        sb.append(H5).append(get("processorLogical")).append(COLON).append(hardware.getProcessor().getLogicalProcessorCount()).append(ENTER);
        sb.append(ENTER).append(ENTER);

        //Memory
        sb.append(BOLD).append(get("memory")).append(BOLD).append(ENTER);
        sb.append(H5).append(get("memoryTotalSize")).append(COLON).append(getMemorySize(hardware.getMemory().getTotal())).append(ENTER);
        sb.append(H5).append(get("physicalMemoryCount")).append(COLON).append(hardware.getMemory().getPhysicalMemory().length).append(ENTER);
        sb.append(getPhysicalMemory(hardware.getMemory())).append(ENTER).append(ENTER);
        sb.append(LINE).append(ENTER);

        //Disk
        sb.append(BOLD).append(get("storage")).append(BOLD).append(ENTER).append(ENTER);
        sb.append(getDiskStores(hardware.getDiskStores()));
        sb.append(ENTER).append(ENTER).append(LINE).append(ENTER);


        //Network Interface
        sb.append(BOLD).append(get("networkInterface")).append(BOLD).append(ENTER).append(ENTER);
        sb.append(getNetworkInterface(hardware.getNetworkIFs()));
        sb.append(getGatewayAndDNS(os.getNetworkParams()));
        sb.append(LINE).append(ENTER);

        /**
         *      File System
         */
        sb.append(H4).append(get("fileSystem")).append(ENTER).append(ENTER);
        sb.append(getFileSystem(os.getFileSystem()));
        sb.append(ENTER).append(ENTER);

        /**
         *      Network Traffic Information
         */
        sb.append(H4).append(BOLD).append(get("networkTrafficInfo")).append(BOLD).append(ENTER).append(ENTER);


        System.out.println(sb.toString());

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {

        Map<String, String> map = new HashMap<>();
        map.put("text", InfoUtils.get("currentStatus") + ": " + InfoUtils.getHostname());
        map.put("desp", InfoUtils.getDeviceInfo());

        HttpClientUtil.doPost("https://sc.ftqq.com/SCU48981T4fb6e368a395cf49b26f8bec99fe6cbf5cb93aed4ba36.send", map);


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
            return prop.getProperty(propertyName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static String getInternetIP() {
        String ip = get("internetIPException");
        try {
            HttpResponse response = HttpClientUtil.get("http://whatismyip.akamai.com");
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
        return String.format("%.1f%%", processor.getSystemCpuLoadBetweenTicks(prevTicks) * 100);
    }

    private static String getAvailableMemory(GlobalMemory memory) {
//        VirtualMemory vm = memory.getVirtualMemory();
        StringBuffer sb = new StringBuffer();
        if (memory.getTotal() < 1048576) {
            sb.append(memory.getAvailable() / 1024 / 1024).append(" MB").append("/");
            sb.append(memory.getTotal() / 1024 / 1024).append(" MB");
        } else {
            double available = memory.getAvailable();
            sb.append(String.format("%.2f", available / 1024 / 1024 / 1024)).append(" GiB").append("/");
            double total = memory.getTotal();
            sb.append(String.format("%.2f", total / 1024 / 1024 / 1024)).append(" GiB");
        }
        return sb.toString();

    }

    private static String getCpuTemperture(Sensors sensors) {
        if (sensors.getCpuTemperature() < 0.1 || sensors.getCpuTemperature() == 0) {
            return get("temperatureException");
        } else {
            return String.format(String.format("%.2f", sensors.getCpuTemperature())) + "℃";
        }
    }

    private static String getFanSpeed(Sensors sensors) {
        StringBuffer sb = new StringBuffer();
        for (int speed : sensors.getFanSpeeds()) {
            if (speed < 1) {
                return get("fanSpeedException");
            } else {
                sb.append(speed).append(" / ");
            }
        }
        if (sb.length() < 4) {
            return get("fanSpeedException");
        }
        String fanSpeed = sb.substring(0, sb.length() - 2);
        return fanSpeed;
    }

    private static String getCpuVoltage(Sensors sensors) {
        if (sensors.getCpuVoltage() < 0.1 || sensors.getCpuVoltage() == 0) {
            return get("cpuVoltageException");
        } else {
            return String.valueOf(sensors.getCpuVoltage());
        }
    }

    private static String getMark() {
        String mark = get("markException");
        try {
            mark = getPropertiesValue("mark");
            if (StringUtils.isEmpty(mark) || "null".equals(mark)) {
                return get("markException");
            }
        } catch (Exception e) {
            return mark;
        }
        return mark;
    }

    private static String getNetworkTraffic(NetworkIF[] networkIFs) {
        StringBuilder sb = new StringBuilder();
        double traffic = 0;
        if (networkIFs.length == 0) {
            sb.append(" Unknown");
        }
        for (NetworkIF net : networkIFs) {
            if (net.getIPv4addr().length < 1) {
                continue;
            }
            try {
                long download1 = net.getBytesRecv();
                Thread.sleep(2000); //Sleep for a bit longer, 2s should cover almost every possible problem
                net.updateAttributes(); //Updating network stats
                long download2 = net.getBytesRecv();
                long result = download2 - download1;
                if (result > 1048576) {
                    traffic = result / 1024 / 1024 / 2;
                    sb.append(traffic).append(" MB/s | ");
                } else {
                    traffic = result / 1024 / 2;
                    sb.append(traffic).append(" KB/s | ");
                }

            } catch (Exception e) {
                e.printStackTrace();
                return get("networkTrafficException");
            }

        }
        String trafficResult = get("networkTrafficException");
        if (sb.length() > 5) {
            trafficResult = sb.substring(0, sb.length() - 2);
        }

        return trafficResult;
    }
    // return String.format(String.format("%.2f", sensors.getCpuTemperature()))+"℃";

    private static String getFormatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }


    private static String getMemorySize(long size) {
        double dSize = size;
        StringBuffer sizeBuffer = new StringBuffer();
        if (size < 1048576) {
            sizeBuffer.append(String.format("%.2f", dSize / 1024 / 1024)).append(" MB");
        } else {
            sizeBuffer.append(String.format("%.2f", dSize / 1024 / 1024 / 1024)).append(" GiB");
        }
        return sizeBuffer.toString();
    }


    private static String getPhysicalMemory(GlobalMemory memory) {
        StringBuffer pmBuffer = new StringBuffer();
        PhysicalMemory[] pmArray = memory.getPhysicalMemory();
        if (pmArray.length > 0) {
            int count = 1;
            for (PhysicalMemory pm : pmArray) {
                pmBuffer.append(POINT).append(ENTER).append(H5).append(get("physicalMemorySize")).append(COLON).append(getMemorySize(pm.getCapacity())).append(ENTER);
                pmBuffer.append(H5).append(get("physicalMemoryBankLabel")).append(COLON).append(pm.getBankLabel()).append(ENTER);
                pmBuffer.append(H5).append(get("physicalMemoryClockSpeed")).append(COLON).append(FormatUtil.formatHertz(pm.getClockSpeed())).append(ENTER);
                pmBuffer.append(H5).append(get("physicalMemoryType")).append(COLON).append(pm.getMemoryType()).append(ENTER);
                pmBuffer.append(H5).append(get("physicalMemoryManufacturer")).append(COLON).append(pm.getManufacturer()).append(ENTER);
                pmBuffer.append(ENTER);
            }
        }
        return pmBuffer.toString();
    }

    private static String getDiskStores(HWDiskStore[] diskStores) {
        StringBuffer diskBuffer = new StringBuffer();
        for (HWDiskStore disk : diskStores) {
            diskBuffer.append(POINT).append(ENTER).append(H5).append(get("diskName")).append(COLON).append(disk.getModel()).append(ENTER);
            diskBuffer.append(H5).append(get("diskCapacity")).append(COLON).append(FormatUtil.formatBytesDecimal(disk.getSize())).append(ENTER);
        }
        return diskBuffer.toString();
    }

    private static String getFileSystem(FileSystem fileSystem){
        StringBuffer sb = new StringBuffer();
        OSFileStore[] fsArray = fileSystem.getFileStores();
        for (OSFileStore fs : fsArray) {
            sb.append(POINT).append(ENTER).append(H5).append(get("volumeName")).append(COLON).append(fs.getName()).append(ENTER);
            sb.append(H6).append(get("logicalVolume")).append(COLON).append(fs.getType()).append(ENTER);
            sb.append(H6).append(get("usedSpace")).append(COLON).append(getMemorySize(fs.getUsableSpace())).append(ENTER);
            sb.append(H6).append(get("totalSpace")).append(COLON).append(getMemorySize(fs.getTotalSpace())).append(ENTER);
            sb.append(H6).append(get("usedRate")).append(COLON).append(calcPercent(fs.getUsableSpace(),fs.getTotalSpace())).append(ENTER);
            sb.append(H6).append(get("volume")).append(COLON).append(fs.getVolume()).append(ENTER);
            sb.append(H6).append(get("logicalVolume")).append(COLON).append(fs.getLogicalVolume()).append(ENTER);
            sb.append(H6).append(get("mountPoint")).append(COLON).append(fs.getMount()).append(ENTER);
            sb.append(H6).append(get("fsUuid")).append(COLON).append(fs.getUUID()).append(ENTER);
        }

        return sb.toString();
    }
    private static String calcPercent(long min, long max){
        StringBuffer percentBuffer = new StringBuffer();
        double dMin=min;
        double dMax=max;
        percentBuffer.append(String.format("%.2f", (dMin/dMax)*100)).append("%");
        return percentBuffer.toString();
    }

    private static String getNetworkInterface(NetworkIF[] networkIFs){
        StringBuffer sb = new StringBuffer();
        if (networkIFs.length == 0) {
            sb.append(H6).append(get("networkInterfaceException")).append(ENTER);
        }

        for (NetworkIF net : networkIFs) {

//            System.out.println(Arrays.toString(net.getIPv4addr()));
            if (net.getIPv4addr().length > 0) {
                sb.append(POINT).append(ENTER).append(H5).append(get("interfaceName")).append(COLON).append(net.getDisplayName()).append(ENTER);
                sb.append(H5).append(get("IPv4Addr")).append(COLON).append(net.getIPv4addr()[0]).append(ENTER).append(ENTER);
            }
            if (net.getIPv6addr().length>0){
                sb.append(POINT).append(ENTER).append(H5).append(get("interfaceName")).append(COLON).append(net.getDisplayName()).append(ENTER);
                sb.append(H5).append(get("IPv6Addr")).append(COLON).append(net.getIPv6addr()[0]).append(ENTER).append(ENTER);
            }
        }
        return sb.toString();
    }
    private static String getGatewayAndDNS(NetworkParams networkParams){

        StringBuffer sb = new StringBuffer();
        sb.append(POINT).append(ENTER);
        for (String dns: networkParams.getDnsServers()){
            sb.append(H5).append(get("dns")).append(COLON).append(dns).append(ENTER);
        }
        sb.append(POINT).append(ENTER).append(H5).append(get("IPv4Gateway")).append(COLON).append(networkParams.getIpv4DefaultGateway()).append(ENTER);
        sb.append(POINT).append(ENTER).append(H5).append(get("IPv6Gateway")).append(COLON).append(networkParams.getIpv6DefaultGateway()).append(ENTER);
        return sb.toString();
    }
}
