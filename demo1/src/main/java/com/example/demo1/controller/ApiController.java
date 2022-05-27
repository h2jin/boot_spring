package com.example.demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/get")
public class ApiController {

	// URL : 자원을 요청하는 주소체계 방식  
	// URI : 식별자 방식. 스프링에서는 URL 방식 못쓰게되어있음. 모두 URI 방식 사용.
	
	// http://localhost:9090/api/hello
//	http://localhost:9090/api/get/hello
	@GetMapping("/hello")
	public String getHello() {
		return "sayhello";
	}
	
	//path-variable 방식
	// get -> URI 방식 사용 (데이터를 담아서 요청) // 처리를 하고 // 응답 가능
	// http://localhost:9090/api/get/path-valiable/[XXXXX]
	@GetMapping(path = "/path-variable/{name}")
	public String queryParam(@PathVariable(name = "name") String name) {
		System.out.println("브라우저에서 들어온 값을 받음 : " + name);
		return "[["+ name + "]]";
	}
	
	// http://localhost:9090/api/get/path-valiable/[XXXXX]
	@GetMapping(path = "/path-variable/{name}/{age}")
	public String queryParam2(@PathVariable(name = "name") String name,
			@PathVariable(name = "age") int age) {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		return "name : " + name + "," + "age" + age;
	}
	
	// 문제 1 새로운 주소 만들어서 요청 응답 (인자값 하나)
	// http://localhost:9090/api/get/path-valiable/[address]
	@GetMapping(path = "/abc/{address}")
	public String queryParam3(@PathVariable(name = "address") String address) {
		return "address : " + address; 
	}
	
	// 문제 2 새로운 주소 만들어서 요청 응답 (인자값 두개)
	
	@GetMapping(path = "/abc/{address}/{product}")
	public String queryParam4(@PathVariable(name = "address")String address,
			@PathVariable(name = "product") String product) {
		return "address : " + address + "product : " + product;
	}
 	
}
