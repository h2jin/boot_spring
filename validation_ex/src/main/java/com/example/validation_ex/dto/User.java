package com.example.validation_ex.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class User {
	
	@NotBlank(message = "아이디를 입력해주세요")
	private String id;
	private String name;
	@Max(value = 100, message = "나이를 잘못 입력하셨습니다")
	@Min(value = 13, message = "나이를 잘못 입력하셨습니다")
	private int age;
	@Email
	private String email;
	private String address;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", address=" + address + "]";
	}
	
	

}
