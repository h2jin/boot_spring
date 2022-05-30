package com.example.demo2_ex.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2_ex.dto.UserRequest;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
	
	// http://localhost:9090/api/get/path-variable/{id}/{pw}
	@GetMapping(path = "/path-variable/{id}/{pw}")
	public String queryParam(@PathVariable(name = "id") String id,
			@PathVariable(name = "pw") String pw) {
		
		String userId = "[" + id + "]";
		String userPw = "[" + pw + "]";
		
		
		return "id : " + userId + "\n" + "pw : " + userPw;
	}
	
	// http://localhost:9090/api/get/query-param1/
	@GetMapping("query-param1")
	public String queryParam1(@RequestParam String id, @RequestParam String pw, @RequestParam String name) {
		
		String userId = "id : " + id;
		String userPw = "pw : " + pw;
		String userName = "name : " + name;
		
		return userId + "\n" + userPw + "\n" + userName;
	}
	
	// http://localhost:9090/api/get/query-param2/
	@GetMapping("query-param2")
	public String queryParam2(@RequestParam Map<String, String> data) {
		
		StringBuffer sb = new StringBuffer();
		data.entrySet().forEach(entry -> {
			sb.append(entry.getKey() + "=" + entry.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	// http://localhost:9090/api/get/query-param3/
	@GetMapping("query-param3")
	public String queryParam3(UserRequest request) {
		
		return request.toString();
	}
	
	
	
}
