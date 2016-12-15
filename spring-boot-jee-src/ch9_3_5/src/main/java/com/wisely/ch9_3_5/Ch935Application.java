package com.wisely.ch9_3_5;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ch935Application implements CommandLineRunner{
	@Autowired
	private AmqpTemplate amqpTemplate; //1

    public static void main(String[] args) {
        SpringApplication.run(Ch935Application.class, args);
    }
   /*
    @Bean //2
    public Queue wiselyQueue(){
        return new Queue("my-queue");
    }
    */

	@Override
	public void run(String... args) throws Exception {
		 amqpTemplate.convertAndSend("my-queue", "来自RabbitMQ的问候"); //3
	}
}
