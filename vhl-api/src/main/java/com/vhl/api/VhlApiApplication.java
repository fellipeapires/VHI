package com.vhl.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class VhlApiApplication extends SpringBootServletInitializer {
	
private static ApplicationContext APPLICATION_CONTEXT;
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(VhlApiApplication.class);
    }


	public static void main(String[] args) {
		SpringApplication.run(VhlApiApplication.class, args);
	}
	
	public static <T> T getBean(Class<T> type) {
		return APPLICATION_CONTEXT.getBean(type);
	}

}
