package com.spring.sample.rabbitmq.springsamplerabbitmq.tut1;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RabbitListener(queues = "hello")
@Service
public class Tut1Receiver {
	
	@RabbitListener(queues = "hello")
	public void receive(String message) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Consuming: " + message);
	}

}
