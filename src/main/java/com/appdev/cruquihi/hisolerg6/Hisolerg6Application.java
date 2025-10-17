package com.appdev.cruquihi.hisolerg6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.appdev.cruquihi")
@EntityScan(basePackages = "com.appdev.cruquihi.entity")
@EnableJpaRepositories(basePackages = "com.appdev.cruquihi.repository")
public class Hisolerg6Application {

	public static void main(String[] args) {
		SpringApplication.run(Hisolerg6Application.class, args);
	}

}
