package com.rabbit.exercise;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class NewTask {

	 private static final String TASK_QUEUE_NAME = "task_queue";
	 
	 public static void newTask(String[] argv) throws IOException, TimeoutException {
		 ConnectionFactory factory = new ConnectionFactory();
		 factory.setHost("localhost");
		 try (Connection connection = factory.newConnection();
			 Channel channel = connection.createChannel()) {
			 channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

			 String message = String.join(" ", argv);

			 channel.basicPublish("", TASK_QUEUE_NAME,
					 MessageProperties.PERSISTENT_TEXT_PLAIN,
					 message.getBytes("UTF-8"));
			 System.out.println(" [x] Sent '" + message + "'");
		 }
	 }
}
