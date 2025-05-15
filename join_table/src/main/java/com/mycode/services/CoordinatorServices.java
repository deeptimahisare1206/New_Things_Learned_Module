package com.mycode.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycode.dao.CoordinatorRepository;
import com.mycode.dao.UserRepository;
import com.mycode.models.Coordinator;
import com.mycode.models.User;
import com.mycode.utils.CoordinatorJsonFile;

@Service
public class CoordinatorServices {

   

	@Autowired
	CoordinatorRepository coordinatorRepository;
	
	@Autowired
	UserRepository userrepository;

	@Autowired
	CoordinatorJsonFile jsonfile;
    
	
	public Coordinator newcoordinator(Coordinator request) {
		User user = new User();
		user.setUsername(request.getFirst_name());
		user.setSetRole("COORDINATOR");
		userrepository.save(user);
		request.setUser(user);
		Coordinator coord = coordinatorRepository.save(request);
		jsonfile.writeCoordinatorsList(request);
		 return coord ; 
		 }
	public List<Coordinator> allCoordinatorsList(){
		List<Coordinator> list1 = coordinatorRepository.findAll();
		return list1;
		
	}
}
