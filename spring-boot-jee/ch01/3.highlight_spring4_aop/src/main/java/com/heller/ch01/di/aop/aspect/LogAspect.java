package com.heller.ch01.di.aop.aspect;

import com.heller.ch01.di.aop.annotation.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 使用@Aspect来注解声明一个切面
 */
@Aspect
@Component
public class LogAspect {

    /**
     * 使用@Pointcut注解来标识一个切点
     */
    @Pointcut("@annotation(com.heller.ch01.di.aop.annotation.Action)")
    public void annotationPointcut() {}

    @After("annotationPointcut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截：" + " 方法名称：" + method.getName() + ", Action.name：" + action.name());
    }

    @Before("execution(* com.heller.ch01.di.aop.service.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截：" + " 方法名称：" + method.getName());
    }

}
