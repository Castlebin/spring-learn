package com.heller.ch01.di;

import com.heller.ch01.di.config.DiConfig;
import com.heller.ch01.di.service.UserFuntionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);

        UserFuntionService userFuntionService = context.getBean(UserFuntionService.class);
        System.out.println(userFuntionService.sayHello("di"));

        context.close();
    }
}
