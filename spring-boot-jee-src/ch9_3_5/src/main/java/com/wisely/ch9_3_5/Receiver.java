package com.wisely.ch9_3_5;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitListener(queues = Ch935Application.MY_QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }

}
