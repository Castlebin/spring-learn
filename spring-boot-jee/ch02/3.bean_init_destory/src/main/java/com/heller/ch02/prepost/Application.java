package com.heller.ch02.prepost;

import com.heller.ch02.prepost.config.PrePostConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrePostConfig.class);

        context.close();
    }
}
