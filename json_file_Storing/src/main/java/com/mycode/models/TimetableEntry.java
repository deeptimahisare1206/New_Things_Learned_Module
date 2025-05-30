package com.mycode.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

//@Entity
public class TimetableEntry {
//	@Id
//	private Integer id;
    private String courseName;
    private String day;
    private String time;
    private CoordinatorRequest coordinator;
    public TimetableEntry() {}
    public TimetableEntry(String courseName, String day, String time) {
        this.courseName = courseName;
        this.day = day;
        this.time = time;
    }
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

    // Getters and setters
    
}

