package com.sapient.jmsPro.Producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.sapient.jmsPro.model.Notification;

@Component("producer")
public class Producer {
	
	@Autowired
	@Qualifier("jmsTopicTemplate")
	private JmsTemplate jmsTopicTemplate;
	
	public void convertAndSendTopic(Notification notification) {
		jmsTopicTemplate.convertAndSend("myTest.topic", notification);
	}

}
