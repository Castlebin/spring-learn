package com.heller.ch02.event;

import com.heller.ch02.event.config.EventConfig;
import com.heller.ch02.event.event.DemoPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);

        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
        demoPublisher.publish("Hello application event");

        context.close();
    }
}
