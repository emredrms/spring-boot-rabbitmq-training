package com.spring.sample.rabbitmq.springsamplerabbitmq.tut1;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Tut1Sender {

	@Autowired
    private RabbitTemplate template;

    public void send() {
        String message = "Hello World!";
        this.template.convertAndSend("hello", message);
        System.out.println(" [x] Sent '" + message + "'");
    }
	
}
