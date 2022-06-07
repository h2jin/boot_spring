package com.example.exception3.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class User {
	
	@NotNull
	@Size(min = 2, max = 20)
	private String name;
	
	@NotNull
	@Min(10)
	private Integer age;

}
