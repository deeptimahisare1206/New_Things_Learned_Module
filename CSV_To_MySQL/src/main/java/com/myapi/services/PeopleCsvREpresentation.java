package com.myapi.services;

import com.opencsv.bean.CsvBindByName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PeopleCsvREpresentation {

	@CsvBindByName(column = "id")
	private Integer id;
	@CsvBindByName(column = "description")
	private String description;
	@CsvBindByName(column = "name")
	private String name;
	@CsvBindByName(column = "num1")
	private Double num1;
	@CsvBindByName(column = "num2")
	private Double num2;
	@CsvBindByName(column = "num3")
	private Double num3;
	@CsvBindByName(column = "num4")
	private Double num4;
	@CsvBindByName(column = "place")
	private String place;
	@CsvBindByName(column = "category")
	private String category;
	@CsvBindByName(column = "rate")
	private Double rate;
}
