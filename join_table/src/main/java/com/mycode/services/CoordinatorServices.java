package com.mycode.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycode.dao.CoordinatorRepository;
import com.mycode.dao.SubjectsRepository;
import com.mycode.dao.UserRepository;
import com.mycode.models.Coordinator;
import com.mycode.models.RegistrationDTO;
import com.mycode.models.Subjects;
import com.mycode.models.User;
import com.mycode.utils.CoordinatorJsonFile;

@Service
public class CoordinatorServices {

   

	@Autowired
	CoordinatorRepository coordinatorRepository;
	
	@Autowired
	UserRepository userrepository;
	@Autowired
	SubjectsRepository subjectsRepository;
	
	@Autowired
	CoordinatorJsonFile jsonfile;
    
	
	public Coordinator newcoordinator(RegistrationDTO dto) {
	    // 1. Save User
	    User user = new User();
	    user.setUsername((dto.getFirstName()+"_"+dto.getLastName()).toLowerCase());
	    user.setSetRole("COORDINATOR");
	    user = userrepository.save(user); // Save and attach user

	    // 2. Handle Subject creation or retrieval
	    Subjects subject = subjectsRepository.findBySubjectName(dto.getSubjectName());

	    if (subject == null) {
	        subject = new Subjects();
	        subject.setSubjectName(dto.getSubjectName());
	        subject.setSubjectCode(dto.getSubjectCode());
	        subject = subjectsRepository.save(subject); // Persist new subject
	    }

	    // 3. Create new Coordinator
	    Coordinator coordinator = new Coordinator();
	    coordinator.setFirst_name(dto.getFirstName());
	    coordinator.setLast_name(dto.getLastName());
	    coordinator.setEmail(dto.getEmail());
	    coordinator.setPhone_no(dto.getPhoneNo());
	    coordinator.setDepartment(dto.getDepartment());
	    coordinator.setUser(user); // Assign persisted user

	    // Create new HashSet to avoid Hibernate tracking issues
	    Set<Subjects> subjectSet = new HashSet<>();
	    subjectSet.add(subject);
	    coordinator.setSubject(subjectSet);

	    // 4. Save the coordinator (persist relationship)
	    Coordinator savedCoordinator = coordinatorRepository.save(coordinator);

	    // 5. Write to JSON (safe after save)
	    jsonfile.writeCoordinatorsList(savedCoordinator);

	    return savedCoordinator;
	}


	public List<Coordinator> allCoordinatorsList(){
		List<Coordinator> list1 = coordinatorRepository.findAll();
		return list1;
		
	}
}
