package com.mycode.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycode.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{


}
