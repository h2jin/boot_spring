package com.example.demo3.dto;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

// 스네이크 케이스든 카멜 케이스든 상관 없이 모두 카멜케이스로 바꾸주는 것.
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PutRequestDto {
	
	private String name;
	private String age;
	
	// list
	private List<CarDto> carList;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public List<CarDto> getCarList() {
		return carList;
	}
	public void setCarList(List<CarDto> carList) {
		this.carList = carList;
	}
	
	@Override
	public String toString() {
		return "PutRequestDto [name=" + name + ", age=" + age + ", carList=" + carList + "]";
	}
	
	
	
	
	

}
