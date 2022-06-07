package com.example.jsp_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	//http://localhost:8000/board/index
	@GetMapping("/index")
	public String index() {
		
		return "index";
	}
	
	//http://localhost:8000/board/home
	@GetMapping("/home")
	public String home() {
		//WEB_INF/views/home.jsp
		return "home";
	}

}
