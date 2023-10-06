package com.systemadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient

public class AdminMicroserviceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AdminMicroserviceApplication.class, args);
	}

}
