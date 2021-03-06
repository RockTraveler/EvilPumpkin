package com.evil.pumpkin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.io.File;
import java.util.List;

@Configuration
public class I18nConfig {

    /**
     * 指定的国际化文件目录, 默认是i18n文件夹
     */
    @Value("${spring.messages.baseFolder:i18n}")
    private String baseFolder;

    // 配置cookie语言解析器
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setCookieMaxAge(3600);      // cookie有效时长，单位秒
        resolver.setCookieName("Language");  //设置存储的Cookie的name为Language
        return resolver;
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            //拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
                registry.addInterceptor(new LocaleChangeInterceptor()).addPathPatterns("/**");
            }
        };
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        if (!StringUtils.isEmpty(baseFolder)) {
            try {
                messageSource.setDefaultEncoding("UTF-8");
                messageSource.setBasenames("i18n/messages");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return messageSource;
    }


    /**
     * 遍历所有文件
     *
     * @param basenames
     * @param folder
     * @param path
     */
    private void getAllFile(List<String> basenames, File folder, String path) {
        if (folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                this.getAllFile(basenames, file, path + folder.getName() + File.separator);
            }
        } else {
            String i18Name = getI18FileName(path + folder.getName());
            if (!basenames.contains(i18Name)) {
                basenames.add(i18Name);
            }
        }
    }

    /**
     * 把普通文件名转换成国际化文件名
     *
     * @param filename
     * @return 文件名
     */
    private String getI18FileName(String filename) {
        filename = filename.replace(".properties", "");
        int index = filename.indexOf("_");
        if (index > -1) {
            filename = filename.substring(0, index);
        }
        return filename;
    }
}
