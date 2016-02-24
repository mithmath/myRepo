package com.sapient.jmsPro.Receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.jmsPro.model.Notification;

@Component("asyncTopicReceiver")
public class AsyncTopicReceiver {
	
	@Autowired
	private NotificationRegistry registry;

	public void receive(Notification notification) {
		
		registry.registerNotification(notification);
	}

}
