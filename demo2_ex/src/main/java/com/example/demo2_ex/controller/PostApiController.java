package com.example.demo2_ex.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2_ex.dto.UserRequest;

@RestController
@RequestMapping("/api2")
public class PostApiController {
	
	// http://localhost:9090/api2/post1
	@PostMapping("/post1")
	public String post1(@RequestBody Map<String, Object> requestData) {
		StringBuffer sb = new StringBuffer();
		requestData.entrySet().forEach(entry -> {
			sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
		});
		return sb.toString();
	}
	
	// http://localhost:9090/api2/post2
	@PostMapping("/post2")
	public String post2(@RequestBody UserRequest request) {
		
		return request.toString();
	}

}
