package com.spring.sample.rabbitmq.springsamplerabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.spring.sample.rabbitmq.springsamplerabbitmq.tut1.Tut1Receiver;
import com.spring.sample.rabbitmq.springsamplerabbitmq.tut1.Tut1Sender;

@SpringBootApplication
@EnableScheduling
public class SpringSampleRabbitmqApplication implements CommandLineRunner  {

	@Autowired
	private Tut1Sender sender;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSampleRabbitmqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		sender.send();
	}



}