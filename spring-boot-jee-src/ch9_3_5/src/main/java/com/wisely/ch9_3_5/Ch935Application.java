package com.wisely.ch9_3_5;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ch935Application implements CommandLineRunner {

    public static final String MY_QUEUE_NAME = "my-queue-name";

    @Autowired
    private AmqpTemplate amqpTemplate; // 1

    public static void main(String[] args) {
        SpringApplication.run(Ch935Application.class, args);
    }

    @Bean // 2
    public Queue wiselyQueue() {
        return new Queue(MY_QUEUE_NAME);
    }

    @Override
    public void run(String... args) throws Exception {
        amqpTemplate.convertAndSend(MY_QUEUE_NAME, MY_QUEUE_NAME + ": " + "来自RabbitMQ的问候"); // 3
    }

}
