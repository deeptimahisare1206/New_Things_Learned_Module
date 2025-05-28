package com.myapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapi.entity.People;

public interface PeopleRepository extends JpaRepository<People, Integer> {

	
}
