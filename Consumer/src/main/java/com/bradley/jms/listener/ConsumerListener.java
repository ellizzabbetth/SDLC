package com.bradley.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


// MBD
@Component
public class ConsumerListener implements MessageListener {
	// JMS Template is wired with connection info to our
	// ActiveMQ and with connection factory
	// Converts and sends object (in this case String) to the queque
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		System.out.println("In onMessage");
		String json = null;
	
		if(message instanceof TextMessage) {
			try {
				json = ((TextMessage) message).getText();
			} catch (JMSException e){
				
				jmsTemplate.convertAndSend(json);
				
			}
		
		}
	}

}
