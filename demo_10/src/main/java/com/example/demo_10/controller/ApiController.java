package com.example.demo_10.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_10.dto.User;

@RestController
@RequestMapping("api")
public class ApiController {
	
	@GetMapping("/userlist")
	public List<User> userList() {
		return User.sampleUser();
	}
	
	

}
