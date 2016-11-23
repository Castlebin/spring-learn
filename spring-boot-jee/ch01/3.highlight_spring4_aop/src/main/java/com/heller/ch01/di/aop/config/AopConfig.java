package com.heller.ch01.di.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 使用@Configuration 标识这是一个配置类
 * 使用@ComponentScan 配置包扫描
 * 使用@EnableAspectJAutoProxy 标识开启AspectJ AOP支持
 */
@Configuration
@ComponentScan("com.heller.ch01.di.aop")
@EnableAspectJAutoProxy
public class AopConfig {
}
