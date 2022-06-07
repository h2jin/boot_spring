package com.example.exception2.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception2.dto.User;

@RestController
@RequestMapping("/api")
@Validated // get 방식일 때 validation 처리
public class ApiController {
	
	// 주소 post 방식과 같음. 메서드 방식이 다른 것을 컴파일러가 구분할 수 있기 때문에 오류나지 않음
	// 또한 메서드 오버로딩으로 매개변수가 다르기 때문에 메서드 이름이 같아도 컴파일러가 구분할 수 있음.
	@GetMapping("/user")
	public User user(@Size(min = 2, max = 20) @RequestParam(required = true) String name, 
			@NotNull
			@Min(1)
			@RequestParam(required = true) Integer age) {
		int mAge = age + 10;
		
		User user = new User();	
		user.setName(name);
		user.setAge(mAge);
		return user;
	}
	
	@PostMapping("/user")
	public User user(@Valid @RequestBody User user) {
		return user;
	}

}
