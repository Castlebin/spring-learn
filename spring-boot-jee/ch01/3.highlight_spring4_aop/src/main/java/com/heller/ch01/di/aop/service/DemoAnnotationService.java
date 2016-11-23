package com.heller.ch01.di.aop.service;

import com.heller.ch01.di.aop.annotation.Action;
import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {

    /**
     * 一个使用注解被拦截的方法
     */
    @Action(name = "注解式拦截的add操作")
    public void add() {}

}
