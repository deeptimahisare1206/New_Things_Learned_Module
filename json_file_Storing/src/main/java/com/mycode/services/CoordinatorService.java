package com.mycode.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.mycode.dao.copy.CordinatorRepository;
import com.mycode.models.CoordinatorRequest;
import com.mycode.utils.JsonFileWriter;

@Service
public class CoordinatorService {

	
	 @Autowired
	    private JsonFileWriter jsonFileWriter;
//	 @Autowired
//	 private CordinatorRepository cordinatorRepository;

	    public void registerCoordinator(CoordinatorRequest request) {
	    	 
	        // Simulated DB logic here if needed
//	        cordinatorRepository.save(request);

	        // Write to JSON file
	        jsonFileWriter.writeCoordinatorToFile(request);
	    }
}
