package com.mycode.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
//@Entity
public class CoordinatorRequest {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
    private String name;
    private String email;
    private String department;
//    @OneToMany(mappedBy = "coordinator", cascade = CascadeType.ALL)
    private List<TimetableEntry> timetable;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public List<TimetableEntry> getTimetable() {
		return timetable;
	}
	public void setTimetable(List<TimetableEntry> timetable) {
		this.timetable = timetable;
	}
	

    // Getters and setters
}
