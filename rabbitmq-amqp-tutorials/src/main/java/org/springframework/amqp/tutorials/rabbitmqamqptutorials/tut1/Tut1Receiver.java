package org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut1;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Tut1Receiver {

	@RabbitListener(queues = "hello-world")
	public void receive(String in) {
		System.out.println(" [x] Received '" + in + "'");
	}
}
