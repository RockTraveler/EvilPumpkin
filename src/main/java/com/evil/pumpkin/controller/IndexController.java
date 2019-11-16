package com.evil.pumpkin.controller;


import com.evil.pumpkin.EvilPumpkinApplication;
import com.evil.pumpkin.untils.InfoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        logger.info("Entering index page..");
        StringBuffer stringBuffer = new StringBuffer();
        try{
            InputStream in = null;
            String currentPath=System.getProperty("user.dir");
            File file = new File(currentPath+"/application.properties");
            if (file.exists()){
                logger.info("External application property file.");
                in = new FileInputStream(file);
            }else{
                logger.info("Internal application property file.");
                in = new BufferedInputStream(EvilPumpkinApplication.resourceLoader("application.properties"));
            }


            Properties prop = new Properties();
            prop.load(new InputStreamReader(in,"UTF-8"));


            model.addAttribute("serverchanURL",prop.getProperty("serverchan.url",""));
            model.addAttribute("mark",prop.getProperty("mark",""));
            model.addAttribute("language",prop.getProperty("language","0"));
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info("Exit index page");
        return "index";
    }



    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(HttpServletRequest request, HttpServletResponse response,Model model) {
        logger.info("----- BEGIN --- application.properties updating........");
        String mark= request.getParameter("mark");
        String serverchanURL= request.getParameter("serverChan_url");
        String language=request.getParameter("language");
        try {
            OutputStream out = new FileOutputStream(EvilPumpkinApplication.loadFile("application.properties"));
            Properties prop = new Properties();

            prop.setProperty("mark",mark);
            prop.setProperty("language",language);
            prop.setProperty("serverchan.url",serverchanURL);

            prop.store(out,"application.properties updated");

            model.addAttribute("serverchanURL",prop.getProperty("serverchan.url",""));
            model.addAttribute("mark",prop.getProperty("mark",""));
            model.addAttribute("language",prop.getProperty("language","0"));
            logger.info("Current URL: "+serverchanURL);
            if (!StringUtils.isEmpty(serverchanURL)&&isHttpUrl(serverchanURL)){
                EvilPumpkinApplication.sendToServerChan(InfoUtils.getDeviceInfo());
            }

            logger.info("[Success] application.properties updated");
        }catch (Exception e){
            e.printStackTrace();
        }

        logger.info("----- END --- application.properties updating........");
        model.addAttribute("msg","Properties has been updated.");

        return "successUpdate";
    }

    public static boolean isHttpUrl(String urls) {
        boolean isurl = false;
        String regex = "(((https|http)?://)?([a-z0-9]+[.])|(www.))"
                + "\\w+[.|\\/]([a-z0-9]{0,})?[[.]([a-z0-9]{0,})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z0-9]{0,}+|/?)";

        Pattern pat = Pattern.compile(regex.trim());
        Matcher mat = pat.matcher(urls.trim());
        isurl = mat.matches();
        if (isurl) {
            isurl = true;
        }
        return isurl;
    }


}
