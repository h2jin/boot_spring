package com.example.demo4.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * {
 * 	"name" : "kkk",
 *  "age" : 30,
 *  "Phone_number" : "010-1234-1234",
 *  "address" : "부산시 해운대구 우동" 
 * }
 *
 */

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL) // null 값을 내려주지 않고 싶을 때 사용한다. (자동완성 안됨)
// 그러나 클라이언트 입장에서 null이었다가 아니었다가 헷갈릴 수 있으므로 필요할 때 사용하기
public class User {
	
	private String name;
	private int age;
	private String phoneNumber;
	private String address;
	private String idNumber;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", idNumber=" + idNumber + "]";
	}
	
	
	
	

}
