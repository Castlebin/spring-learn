package com.heller.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

import java.io.File;

@Component
public class Receiver {

    /**
     * Get a reference of application context
     */
    @Autowired
    private ConfigurableApplicationContext context;

    /**
     * When you receive a message, print it out, the shutdown the application.
     * Finally, clean up any ActiveMQ server stuff
     */
    @JmsListener(destination = "mailbox-destination")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");

        context.close();
        FileSystemUtils.deleteRecursively(new File("activemq-data"));
    }
}
