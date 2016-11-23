package com.heller.ch02.event.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent event) {
        System.out.println("DemoListener接收到了DemoEvent事件, msg: " + event.getMsg());
    }
}
