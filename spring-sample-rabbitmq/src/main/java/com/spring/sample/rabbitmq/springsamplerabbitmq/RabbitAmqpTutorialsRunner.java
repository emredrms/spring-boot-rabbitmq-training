package com.spring.sample.rabbitmq.springsamplerabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

import com.spring.sample.rabbitmq.springsamplerabbitmq.tut1.Tut1Receiver;
import com.spring.sample.rabbitmq.springsamplerabbitmq.tut1.Tut1Sender;

public class RabbitAmqpTutorialsRunner implements CommandLineRunner {

	@Value("${tutorial.client.duration:0}")
	private int duration;

	@Autowired
	private ConfigurableApplicationContext ctx;
	
	@Autowired
	private Tut1Sender sender;
	
	@Autowired
	private Tut1Receiver receiver;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Ready ... running for " + duration + "ms");
		sender.send();
	}

}
