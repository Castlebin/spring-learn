package com.heller.ch01.di.config;

import com.heller.ch01.di.service.FunctionService;
import com.heller.ch01.di.service.UserFuntionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    public FunctionService functionService() {
        return new FunctionService();
    }

    @Bean
    public UserFuntionService userFuntionService() {
        UserFuntionService userFuntionService = new UserFuntionService();
        userFuntionService.setFunctionService(functionService());

        return userFuntionService;
    }

    /** 与上面代码作用完全一样
     * 而且两者同时存在居然不会出错，哇！
     * @param functionService
     * @return userFuntionService
     */
    @Bean
    public UserFuntionService userFuntionService(FunctionService functionService) {
        UserFuntionService userFuntionService = new UserFuntionService();
        userFuntionService.setFunctionService(functionService);

        return userFuntionService;
    }
}
