package com.heller.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = new SpringApplication("/blog/integration.xml").run(args);
        System.out.println("Hit Enter to terminate");
        System.in.read();
        ctx.close();
    }
}
