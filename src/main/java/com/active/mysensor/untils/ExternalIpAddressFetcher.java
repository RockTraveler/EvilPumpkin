package com.active.mysensor.untils;

import java.io.BufferedReader;
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.net.MalformedURLException;  
import java.net.URL;  
import java.net.URLConnection;  
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
  
public class ExternalIpAddressFetcher {
    // 本机外网IP地址  
    private String myExternalIpAddress;  
  
    public ExternalIpAddressFetcher(String externalIpProviderUrl) {  
        fetchExternalIpProviderHTML(externalIpProviderUrl);  
    }  
  
    private String fetchExternalIpProviderHTML(String externalIpProviderUrl) {
        InputStream ins = null;
  
        URLConnection httpConn = null;
  
        try {  
            URL url = new URL(externalIpProviderUrl);
            httpConn = url.openConnection();  
  
            ins = httpConn.getInputStream();  
            InputStreamReader isReader = new InputStreamReader(ins, "GB2312");  
            BufferedReader bReader = new BufferedReader(isReader);  
            StringBuffer webContent = new StringBuffer();  
            String str = null;  
            while ((str = bReader.readLine()) != null) {  
                if (parse(str)) {  
                    webContent.append(str);  
                    break;  
                }  
            }  
            // 返回  
            return webContent.toString();  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                ins.close();  
            } catch (Exception ex) {  
                ex.printStackTrace();  
            }  
        }  
  
        return null;
    }  
  
    private boolean parse(String html) {
        boolean ret = false;  
        Pattern pattern = Pattern.compile("(\\d{1,3})[.](\\d{1,3})[.](\\d{1,3})[.](\\d{1,3})",  
                Pattern.CASE_INSENSITIVE);  
        Matcher matcher = pattern.matcher(html);  
        while (matcher.find()) {  
            myExternalIpAddress = matcher.group(0);  
            ret = true;  
            break;  
        }  
        return ret;  
    }  
  
    public String getMyExternalIpAddress() {
        return myExternalIpAddress;  
    }  
  
    public static void main(String[] args) {  
        ExternalIpAddressFetcher fetcher = new ExternalIpAddressFetcher("http://1212.ip138.com/ic.asp");  
  
        System.out.println(fetcher.getMyExternalIpAddress());  
    }  
}  