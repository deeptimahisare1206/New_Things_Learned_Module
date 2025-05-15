package com.mycode.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycode.models.Coordinator;

public interface CoordinatorRepository extends JpaRepository<Coordinator, Integer> {

}
