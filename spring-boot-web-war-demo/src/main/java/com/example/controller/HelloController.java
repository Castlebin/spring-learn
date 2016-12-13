package com.example.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello(String name) {
        if (!StringUtils.hasText(name)) {
            name = "World";
        }
        return "Hello, " + name;
    }

}
