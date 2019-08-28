package com.rabbit.exercise;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLog {

	 private static final String EXCHANGE_NAME = "logs";
	 
	 public static void emitLog(String[] args) throws IOException, TimeoutException {
		 ConnectionFactory factory = new ConnectionFactory();
		 factory.setHost("localhost");
		 try (Connection connection = factory.newConnection();
			 Channel channel = connection.createChannel()) {
			 channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

			 String message = args.length < 1 ? "info: Hello World!" :
				 String.join(" ", args);

			 channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
			 System.out.println(" [x] Sent '" + message + "'");
		 }
	 }
	 
}
