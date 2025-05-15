package com.mycode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mycode.models.Coordinator;
import com.mycode.services.CoordinatorServices;

@RestController
@RequestMapping("/api/coordinators")
public class CoordinatorControl {


	@Autowired
	CoordinatorServices coordinatorServices;

  
	@PostMapping("/register")
	public ResponseEntity<Coordinator> newcoordinator(@RequestBody Coordinator request){
//		return  ResponseEntity.ok("Coordinator registerd successfully!");
		coordinatorServices.newcoordinator(request);
		return new ResponseEntity<Coordinator>(HttpStatus.OK);
	}
	@GetMapping("/allcoordinators")
	public ResponseEntity<List<Coordinator>> allCoordinatorsList(){
		List<Coordinator> coordinator = coordinatorServices.allCoordinatorsList();
		return new ResponseEntity<List<Coordinator>>(coordinator,HttpStatus.OK);
	}
	
}
