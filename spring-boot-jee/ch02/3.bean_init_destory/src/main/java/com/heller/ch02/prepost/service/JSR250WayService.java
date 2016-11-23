package com.heller.ch02.prepost.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSR250WayService {

    public JSR250WayService() {
        System.out.println("JSR250WayService 构造函数调用...");
    }

    @PostConstruct
    public void init() {
        System.out.println("JSR250WayService init...");
    }

    @PreDestroy
    public void destory() {
        System.out.println("JSR250WayService destory...");
    }

}
