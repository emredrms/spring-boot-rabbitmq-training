package org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut1;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Tut1Sender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	//@Autowired
	//private Queue queue;

	//@Scheduled(fixedDelay = 1000, initialDelay = 500)
	public void send() {
		
		String message = "Hello World";
		rabbitTemplate.convertAndSend("hello-world", message);
		System.out.println(" [x] Sent '" + message + "'");
	}
}
