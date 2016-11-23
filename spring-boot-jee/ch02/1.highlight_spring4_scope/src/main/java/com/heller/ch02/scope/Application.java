package com.heller.ch02.scope;

import com.heller.ch02.scope.config.ScopeConfig;
import com.heller.ch02.scope.service.DemoPrototypeService;
import com.heller.ch02.scope.service.DemoSingletonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);

        DemoPrototypeService p1 = context.getBean(DemoPrototypeService.class);
        DemoPrototypeService p2 = context.getBean(DemoPrototypeService.class);
        System.out.println("p1 == p2? " + (p1 == p2));

        DemoSingletonService s1 = context.getBean(DemoSingletonService.class);
        DemoSingletonService s2 = context.getBean(DemoSingletonService.class);
        System.out.println("s1 == s2? " + (s1 == s2));
    }
}
