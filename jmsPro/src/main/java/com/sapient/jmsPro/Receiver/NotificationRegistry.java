package com.sapient.jmsPro.Receiver;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.sapient.jmsPro.model.Notification;

@Component("notificationRegistry")
public class NotificationRegistry {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private List<Notification> receivedNotifications = new ArrayList<Notification>();
	
	public List<Notification> getReceivedNotifications() {
		return receivedNotifications;
	}
	
	public void registerNotification(Notification notification) {
		logger.info("inserting notification");
		System.out.println("Message Received :"+notification.getMessage());
		receivedNotifications.add(notification);
	}
	
	public void clear() {
		receivedNotifications.clear();
	}

}
