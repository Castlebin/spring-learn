package com.heller.ch04.controller;

import com.heller.ch04.service.DemoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @Autowired
    private DemoService demoService;

    @ResponseBody
    @RequestMapping(value = "/testRest", produces = "text/plain; charset=utf-8")
    public String testRest() {
        return demoService.saySomething();
    }

}
