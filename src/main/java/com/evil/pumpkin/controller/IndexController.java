package com.evil.pumpkin.controller;


import com.alibaba.fastjson.JSON;
import com.evil.pumpkin.EvilPumpkinApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String index(Model model) {
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
                in = new BufferedInputStream(resourceLoader("application.properties"));
            }


            Properties prop = new Properties();
            prop.load(new InputStreamReader(in,"UTF-8"));


            model.addAttribute("serverchanURL",prop.getProperty("serverchan.url",""));
            model.addAttribute("mark",prop.getProperty("mark",""));
            model.addAttribute("language",prop.getProperty("language","0"));
        }catch (Exception e){
            e.printStackTrace();
        }

        return "index";
    }



    @RequestMapping("/update")
    public String update(HttpServletRequest request, HttpServletResponse response) {
        logger.info("----- BEGIN --- Getting application.properties ........");
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
                in = new BufferedInputStream(resourceLoader("application.properties"));
            }


            Properties prop = new Properties();
            prop.load(in);
            for (String key : prop.stringPropertyNames()) {
                stringBuffer.append(key + "=" + prop.getProperty(key)).append(";");
                logger.info(key + "=" + prop.getProperty(key));
            }
            System.out.println(stringBuffer);
        }catch (Exception e){
            e.printStackTrace();
        }

        logger.info("----- END --- Getting application.properties ........");
        return "update";

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

    public static File loadFile(String fileFullPath) throws IOException {
        ResourceLoader resourceLoader = new FileSystemResourceLoader();
        return resourceLoader.getResource(fileFullPath).getFile();
    }

}
