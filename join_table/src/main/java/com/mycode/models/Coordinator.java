package com.mycode.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Coordinator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String first_name;
	private String last_name;
	private String email;
	private String phone_no;
	private String department;
	
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;
	
}
