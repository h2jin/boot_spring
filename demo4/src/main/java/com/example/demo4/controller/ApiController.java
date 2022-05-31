package com.example.demo4.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo4.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	// MINE_TYPE 어떤 것을 보낼 지 알려줌
	
	// text/plain <-- contentType이 text/plain 
	@GetMapping("/text")
	public String text(@RequestParam String account) {
		return account;
	}
	
	
	//application/json
	@PostMapping("/json")
	// request --> Object Mapper --> Object화 완료돼서 나옴 --> method
	public User json(@RequestBody User user) {
		System.out.println(user.getName());
		return user;
	}
	
	// 202, 200 --> 응답을 돌려 줄 때 응답 코드를 지정해서 보낼 수 있다.
	@PutMapping("/put")
	public ResponseEntity<?> put(@RequestBody User user) {
		// responseEntity를 통해서 statusm header 등을 설정할 수 있다.
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
		
	}
	
	
}
