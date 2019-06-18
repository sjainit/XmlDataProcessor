package com.companyname.JmsActiveMQ.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class consumer {

	@JmsListener(destination = "simple-jms-queue")
	public void listener(String msg) {
		System.out.println("Received Message : " + msg);
	}
}
