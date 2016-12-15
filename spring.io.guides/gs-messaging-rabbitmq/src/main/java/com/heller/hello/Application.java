package com.heller.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        Sender sender = ctx.getBean(Sender.class);
        System.out.println("begin: ");
        sender.sendMsg("ssssss", "fsfhoshfowf");
        System.out.println("xxxxx");
    }

}
