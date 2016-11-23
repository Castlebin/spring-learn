package com.heller.ch01.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFuntionService {
    @Autowired
    private FunctionService functionService;

    public String sayHello(String word) {
        return "UserFunctionService: " + functionService.sayHello(word);
    }
}
