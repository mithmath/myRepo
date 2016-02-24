package com.sapient.jmsPro;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sapient.jmsPro.Producer.Producer;
import com.sapient.jmsPro.Receiver.NotificationRegistry;
import com.sapient.jmsPro.model.Notification;

@ContextConfiguration(locations = {
		"/jms-config.xml", 
		"/app-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestTopicMessaging {
	
	@Autowired
	private Producer producer;
	
	@Autowired
	private NotificationRegistry registry;
	
	@Before
	public void prepareTest() {
		registry.clear();
	}
	
	@Test
	public void testTopicSending() throws InterruptedException {
		Notification notification = new Notification("1", "this is a topic");
		Notification notification2 = new Notification("2", "Hi Sapient");
		Notification notification3 = new Notification("3", "Hi Tesco");
		
		producer.convertAndSendTopic(notification);
		producer.convertAndSendTopic(notification2);
		producer.convertAndSendTopic(notification3);
		
		Thread.sleep(2000);
		
		//assertEquals(3, registry.getReceivedNotifications().size());
		//assertEquals("this is a topic", registry.getReceivedNotifications().get(0).getMessage());
		
		//assertEquals("this is a topic", registry.getReceivedNotifications().get(1).getMessage());
	}

}
