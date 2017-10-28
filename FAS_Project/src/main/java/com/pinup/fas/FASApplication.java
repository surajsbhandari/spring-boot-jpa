package com.pinup.fas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FASApplication {

	public static void main(String[] args) {
		SpringApplication.run(FASApplication.class, args);
		System.out.println("Hello World!");
	}

}
