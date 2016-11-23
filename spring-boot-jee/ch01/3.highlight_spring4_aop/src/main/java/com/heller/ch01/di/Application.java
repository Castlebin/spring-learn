package com.heller.ch01.di;

import com.heller.ch01.di.aop.config.AopConfig;
import com.heller.ch01.di.aop.service.DemoAnnotationService;
import com.heller.ch01.di.aop.service.DemoMethodService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        demoAnnotationService.add();

        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
        demoMethodService.add();

        context.close();
    }
}
