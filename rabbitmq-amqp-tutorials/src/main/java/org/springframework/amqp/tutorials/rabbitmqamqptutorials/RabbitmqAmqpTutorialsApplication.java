package org.springframework.amqp.tutorials.rabbitmqamqptutorials;

import org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut1.Tut1Receiver;
import org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut1.Tut1Sender;
import org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut1.Tut2Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitmqAmqpTutorialsApplication implements CommandLineRunner {

	
	@Autowired
	private Tut1Sender sender;
	
	@Autowired
	private Tut2Sender tut2Sender;

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqAmqpTutorialsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		tut2Sender.send("orange");
		tut2Sender.send("orange2");
	}

}
