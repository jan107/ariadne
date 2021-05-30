package com.es.ariadne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EventTrackingApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(EventTrackingApplication.class, args);
	}
}
