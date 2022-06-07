package com.example.exception3.controller;

import javax.validation.Valid;
import javax.validation.constraints.Max;
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

import com.example.exception3.dto.User;

@Validated
@RestController
@RequestMapping("/api")
public class ApiController {
	
	@GetMapping("/user")
	public User user(@Size(min = 2, max = 20) @NotNull @RequestParam String name, 
			@Min(10) @NotNull @RequestParam Integer age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		return user; 
		
	}
	
	@PostMapping("/user")
	public User user(@Valid @RequestBody User user) {
		return user;
	}

}
