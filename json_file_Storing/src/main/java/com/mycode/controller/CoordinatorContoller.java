package com.mycode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycode.models.CoordinatorRequest;
import com.mycode.services.CoordinatorService;

@RestController 
@RequestMapping("/api/coordinators")
public class CoordinatorContoller {
	 @Autowired
	    private CoordinatorService coordinatorService;

	    @PostMapping("/register")
	    public ResponseEntity<?> register(@RequestBody CoordinatorRequest request) {
	        coordinatorService.registerCoordinator(request);
	        return ResponseEntity.ok("Coordinator registered and saved to JSON file.");
	    }
}
