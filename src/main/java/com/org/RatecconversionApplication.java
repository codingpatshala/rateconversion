package com.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = { "com.org.controller.service.proxy"})
@SpringBootApplication
public class RatecconversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatecconversionApplication.class, args);
	}

}
