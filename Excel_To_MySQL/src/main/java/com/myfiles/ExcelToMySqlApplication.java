package com.myfiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExcelToMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelToMySqlApplication.class, args);
		System.out.println("Started : You can now upload the file.");
	}

}
