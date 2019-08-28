package com.course.rabbitmqproducer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.course.rabbitmqproducer.entity.Employee;
import com.course.rabbitmqproducer.entity.Picture;
import com.course.rabbitmqproducer.producer.EmplyoeeJsonProducer;
import com.course.rabbitmqproducer.producer.HelloRabbitProducer;
import com.course.rabbitmqproducer.producer.HumanResourceProducer;
import com.course.rabbitmqproducer.producer.MyPictureProducer;
import com.course.rabbitmqproducer.producer.PictureProducer;

//@EnableScheduling
@SpringBootApplication
public class RabbitmqProducerApplication implements CommandLineRunner {

	// @Autowired
	// private HelloRabbitProducer helloRabbitProducer;

	// @Autowired
	// private EmplyoeeJsonProducer emplyoeeJsonProducer;

	// @Autowired
	// private HumanResourceProducer humanResourceProducer;
	
	//@Autowired
	//private MyPictureProducer myPictureProducer;

	@Autowired
	private PictureProducer pictureProducer;
	
	private final List<String> TYPES = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("jpg");
			add("png");
			add("svg");

		}
	};

	private final List<String> SOURCES = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("mobile");
			add("web");

		}
	};

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// helloRabbitProducer.sendHello("Timotius " + Math.random());
		for (int i = 0; i < 10; i++) {
			Picture p = new Picture();
			p.setName("Picture " + i);
			p.setSize(ThreadLocalRandom.current().nextLong(2000, 10000));
			p.setSource(SOURCES.get(i % SOURCES.size()));
			p.setType(TYPES.get(i % TYPES.size()));
			
			pictureProducer.sendMessage(p);
		}
	}

}
