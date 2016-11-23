package com.heller.ch02.el.config;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("com.heller.ch02.el")
@PropertySource("classpath:com/heller/ch02/el/test.properties")
public class ELConfig {

    @Value("I Love You!")
    private String normal;

    // 从系统属性
    @Value("#{systemProperties['os.name']}")
    private String osName;

    // 从算术表达式
    @Value("#{ T(java.lang.Math).random() * 100.0}")
    private double randomNumber;

    // 从其他类
    @Value("#{demoService.another}")
    private String fromAnother;

    // 从文件
    @Value("classpath:com/heller/ch02/el/test.txt")
    private Resource testFile;

    // 从网络
    @Value("http://www.baidu.com/")
    private Resource testUrl;

    // 从配置文件
    @Value("${book.name}")
    private String bookName;

    @Autowired
    private Environment environment;

    /**
     * 注意！！此方法声明必须为static
     * 否则会注入出错，不过看错误日志就能知道，小细节
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource() {
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);

            System.out.println(IOUtils.toString(testFile.getInputStream()));

            System.out.println(IOUtils.toString(testUrl.getInputStream()));

            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
