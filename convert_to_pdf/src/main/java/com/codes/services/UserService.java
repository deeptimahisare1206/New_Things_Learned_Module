package com.codes.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codes.entity.Users;
import com.codes.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public List<Users> listAll(){
		
		return userRepo.findAll(Sort.by("email").ascending());
		
	}
	
	public Users createuser(Users users) {
		return userRepo.save(users);
	}
}
