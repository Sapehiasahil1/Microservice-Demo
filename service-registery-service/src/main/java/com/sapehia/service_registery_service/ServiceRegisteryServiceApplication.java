package com.sapehia.service_registery_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegisteryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegisteryServiceApplication.class, args);
	}

}
