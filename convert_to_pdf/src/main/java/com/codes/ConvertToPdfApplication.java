package com.codes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConvertToPdfApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvertToPdfApplication.class, args);
		
		System.out.println("Conversion of data can be started now.....................");
	}

}
