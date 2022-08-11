package com.example.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) { // 페이지를 열 때 모델 객체를 들고감.
		model.addAttribute("name", "홍길동");
		return "home";
	}
	
	@GetMapping("user")
	public String user(Model model) {
		model.addAttribute("user", "홍길동");
		model.addAttribute("age", "30");
		model.addAttribute("address", "부산시 진구");
		return "user";
	}
}
