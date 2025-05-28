package com.myapi.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.myapi.services.PeopleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PeopleController {
	
	
	private final PeopleService peopleService;
	
	@PostMapping(value = "/people/upload",consumes = {"multipart/form-data"})
	public ResponseEntity<Integer> uploadPeople(@RequestPart("file") MultipartFile file) throws IOException{
		
		return ResponseEntity.ok(peopleService.uploadPeople(file));
	}

}
