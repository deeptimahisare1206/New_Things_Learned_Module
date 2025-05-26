package com.mycode.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycode.models.Subjects;

public interface SubjectsRepository extends JpaRepository<Subjects, Integer> {

	Subjects findBySubjectName(String subjectName);
    
}
