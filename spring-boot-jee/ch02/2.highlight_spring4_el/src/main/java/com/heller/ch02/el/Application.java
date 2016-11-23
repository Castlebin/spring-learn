package com.heller.ch02.el;

import com.heller.ch02.el.config.ELConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ELConfig.class);

        ELConfig elConfig = context.getBean(ELConfig.class);

        elConfig.outputResource();

        context.close();
    }
}
