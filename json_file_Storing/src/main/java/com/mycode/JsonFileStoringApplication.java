package com.mycode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mycode.models.CoordinatorRequest;
import com.mycode.models.TimetableEntry;
import com.mycode.services.CoordinatorService;

@SpringBootApplication
public class JsonFileStoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonFileStoringApplication.class, args);
		System.out.println("Start Entering.......................");
	}
	
}
