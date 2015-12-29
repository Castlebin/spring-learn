package com.heller.hello;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Receiver {

    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String message) {
        log.info("Received <" + message + ">");

        latch.countDown();
    }
}
