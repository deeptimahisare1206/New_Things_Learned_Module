package com.myapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class People {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String description;
	private String name;
	private Double num1;
	private Double num2;
	private Double num3;
	private Double num4;
	private String place;
	private String category;
	private Double rate;

}
