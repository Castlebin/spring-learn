package com.heller.ch02.profile;

import com.heller.ch02.profile.bean.DemoBean;
import com.heller.ch02.profile.config.ProfileConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.getEnvironment().setActiveProfiles("prod");
    //    context.getEnvironment().setActiveProfiles("dev");
        context.register(ProfileConfig.class);

        context.refresh();

        DemoBean demoBean = context.getBean(DemoBean.class);
        System.out.println(demoBean.getContent());

        context.close();
    }
}
