package com.myfiles.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	private Integer productId;
	private String productName;
	private String taskName;
	private String assignedTo;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date startDate;
}
