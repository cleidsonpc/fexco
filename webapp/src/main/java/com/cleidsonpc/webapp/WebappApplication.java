package com.cleidsonpc.webapp;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

import com.cleidsonpc.webapp.controller.HomeController;

@SpringBootApplication
@EnableCircuitBreaker
@EnableCaching
public class WebappApplication {
	
	private static final Logger LOG = Logger.getLogger(HomeController.class);
	
	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
		LOG.info("Application was started");
	}
	
}
