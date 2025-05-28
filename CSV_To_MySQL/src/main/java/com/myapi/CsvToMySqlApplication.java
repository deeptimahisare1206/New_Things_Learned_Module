package com.myapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CsvToMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsvToMySqlApplication.class, args);
		System.out.println("Started You can now upload you file!");
	}

}
