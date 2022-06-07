package com.example.exception2.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // name과 age 받는 생성자
public class User {
	
	@NotNull
	@Size(min = 2, max = 20)
	private String name;
	
	@Min(1)
	@NotNull
	private Integer age;

}
