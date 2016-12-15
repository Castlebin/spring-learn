package com.heller.hello;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class Listener {
    @RabbitListener(queues = "someQueue")
    public void processMessage(String content) {
        System.out.println(content);
    }
}
