package com.evil.pumpkin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

    // 配置一个拦截器，拦截国际化语言的变化
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            //拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {

                LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
                System.out.println(interceptor.getParamName());

                registry.addInterceptor(new LocaleChangeInterceptor()).addPathPatterns("/**");
            }
        };
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        if (!StringUtils.isEmpty(baseFolder)) {
            try {
                String[] baseNames = getAllBaseNames(baseFolder);
                messageSource.setDefaultEncoding("UTF-8");
                messageSource.setBasenames(baseNames);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return messageSource;
    }

    /**
     * 获取文件夹下所有的国际化文件名
     *
     * @param folderName 文件名
     * @return
     * @throws IOException
     */
    private String[] getAllBaseNames(String folderName) throws IOException {
        Resource resource = new ClassPathResource(folderName);
        File file = resource.getFile();
        List<String> baseNames = new ArrayList<>();
        if (file.exists() && file.isDirectory()) {
            this.getAllFile(baseNames, file, "");
        } else {
            System.out.println("指定的baseFile不存在或者不是文件夹");
        }
        return baseNames.toArray(new String[baseNames.size()]);
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
