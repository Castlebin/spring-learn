package com.heller.person.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/msg")
@RestController
public class MsgController {

    @Value("${my.message:}")
    private String message;

    @RequestMapping(value = "/getsome")
    public String getsome() {
        return message;
    }

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello(String name) {
        if (!StringUtils.hasText(name)) {
            name = "World";
        }

        return "Hello, " + name.trim();
    }

}
