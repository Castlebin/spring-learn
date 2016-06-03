package com.heller.hello.controller;

import com.heller.hello.dto.Greeting;
import com.heller.hello.dto.HelloMessage;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws InterruptedException {
        Thread.sleep(300); // 模拟网络延迟
        return new Greeting("Hello, " + message.getName() + "!");
    }

}
