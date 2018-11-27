package com.service.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import com.service.consumer.controller.ConsumerControllerClient;

@SpringBootApplication
@EnableEurekaClient
public class PatientApptConsumerApplication {
	private static final Logger logger = LoggerFactory.getLogger(PatientApptConsumerApplication.class);
	public static void main(String[] args) throws RestClientException, IOException {
		ApplicationContext ctx = SpringApplication.run(PatientApptConsumerApplication.class, args);
		/*ConsumerControllerClient consumerControllerClient=ctx.getBean(ConsumerControllerClient.class);
		System.out.println("----------------------- test ---------------------------- "+consumerControllerClient);
		logger.debug("----------------------- test ---------------------------- "+consumerControllerClient);
		//consumerControllerClient.getPatientDetail();
		logger.debug("--Application Started--");*/
	}
	
	@Bean
	public  ConsumerControllerClient  consumerControllerClient()
	{
		return  new ConsumerControllerClient();
	}
}
