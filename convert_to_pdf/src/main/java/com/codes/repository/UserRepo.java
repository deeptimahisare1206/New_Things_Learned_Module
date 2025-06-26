package com.codes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codes.entity.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {

}
