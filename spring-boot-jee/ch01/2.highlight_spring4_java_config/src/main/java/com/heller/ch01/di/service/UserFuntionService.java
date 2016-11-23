package com.heller.ch01.di.service;

public class UserFuntionService {

    private FunctionService functionService;

    public String sayHello(String word) {
        return "UserFunctionService: " + functionService.sayHello(word);
    }

    public FunctionService getFunctionService() {
        return functionService;
    }

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }
}
