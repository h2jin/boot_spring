package com.example.validation.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * { "name" : "홍길동", "age" : 0 , "email" : "a@naver.com", "phoneNumber" :
 * "010-1234-1234" }
 * 
 * @author ITPS
 *
 */

public class User {

//	validation - email 형식인데 @가 없다거나 age인데 소수점이 있는 숫자를 입력한다거나 이런 것을 체크하는 것을 말함.
//	= validation 처리한다.
//	validation 처리하지 않으면 데이터의 무결성도 

	@NotBlank(message = "이름을 입력해 주세요")
	private String name;
	
	@Max(value = 90, message = "나이를 잘못입력하셨습니다.")
	@Min(value = 10, message = "나이를 잘못입력하셨습니다.")
	private int age;

	@Email
	private String email;
	private String phoneNumber;

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}

}
