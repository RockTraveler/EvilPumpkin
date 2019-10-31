package com.active.mysensor.untils;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

import java.io.*;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Properties;

public class InfoUtils {
    private static final int LANGUAGE_SETTING=getLanguage();
    private static final String NEW_LINE="\n";
    private static final String COLON=": ";
    private static String getDeviceInfo(){

        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();


        StringBuffer sb = new StringBuffer();
        // Part 1: Show the base information for your devices.

        sb.append("#####").append(get("baseInfo")).append(NEW_LINE);
        sb.append(get("hostname")).append(COLON).append(getHostname()).append(NEW_LINE);
        sb.append(get("temperature")).append(COLON).append(hal.getSensors().toString());



        return sb.toString();
    }

    public static void main(String[] args)throws Exception {
//        Map<String, String> map = new HashMap<>();
//        map.put("text", get("currentStatus")+ ": "+ getHostname());
//        map.put("desp", getDeviceInfo());
//
//        HttpClientUtil.doPost("https://sc.ftqq.com/SCU48981T4fb6e368a395cf49b26f8bec99fe6cbf5cb93aed4ba36.send",map);


            getMyIP();


    }

    private static String getMyIP() throws IOException {
        InputStream ins = null;
        try {
            //https://ip.ngrok.wang/
            URL url = new URL("http://ip.cn");
            URLConnection con = url.openConnection();
            ins = con.getInputStream();
            InputStreamReader isReader = new InputStreamReader(ins, "utf-8");
            BufferedReader bReader = new BufferedReader(isReader);
            StringBuffer webContent = new StringBuffer();
            String str = null;
            while ((str = bReader.readLine()) != null) {
                webContent.append(str);
            }
            int start = webContent.indexOf("<code>")+6 ;
            int end = webContent.indexOf("</code");
            return webContent.substring(start, end);
        } finally {
            if (ins != null) {
                ins.close();
            }
        }
    }


    private static String getHostname(){
        String hostname  = "unknown host";
        try {
            InetAddress addr = InetAddress.getLocalHost();
            hostname=addr.getHostName();
        }catch (Exception e){
            return "unknown host";
        }
        return hostname;
    }


    private static String get(String name){

        try {
           Field field= RowName.class.getDeclaredField(name);
           field.setAccessible(true);
           List<String> list = (List<String>)field.get(RowName.class);
            return list.get(getLanguage());
        } catch (Exception e) {
            return "unknown row name";
        }
    }

    private static Integer getLanguage(){
        int languageSetting=1;
        try {
            languageSetting=Integer.parseInt(getPropertiesValue("language"));
        }catch (Exception e){
            return languageSetting;
        }
        return languageSetting;
    }


    public static InputStream resourceLoader(String fileFullPath) throws IOException {
        String currentPath=System.getProperty("user.dir");
        File file = new File(currentPath+File.separator+"application.properties");

        ResourceLoader resourceLoader = new DefaultResourceLoader();
        if(file.exists()){
            return  resourceLoader.getResource("file:"+file.getAbsolutePath()).getInputStream();
        }

        return resourceLoader.getResource(fileFullPath).getInputStream();
    }


    private static String getPropertiesValue(String propertyName){
        try{
            InputStream in = new BufferedInputStream(resourceLoader("application.properties"));
            Properties prop = new Properties();
            prop.load(in);
            return  String.valueOf(prop.getProperty(propertyName));

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}