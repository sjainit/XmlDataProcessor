package com.companyname.JmsActiveMQ;

import java.awt.TrayIcon.MessageType;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

import com.rabbitmq.client.ConnectionFactory;

import ch.qos.logback.classic.pattern.MessageConverter;

@EnableJms
@SpringBootApplication
public class SpringBootActiveMqInMemoryExampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootActiveMqInMemoryExampleApplication.class, args);
  }

}