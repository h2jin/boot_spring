package com.example.validation.controller;

import java.util.ArrayList;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation.dto.User;

@RestController
@RequestMapping("/api")
@Validated // get 방식일 때 Valid 처리
public class ApiController {
	
	// get 방식일 때 valid 처리하기
	// QueryParam 방식 -> ?name=홍길동&age=50
	@GetMapping("/user")
	public User user(@Size(min = 2) @RequestParam String name,
			@NotNull @Min(1) @RequestParam Integer age) {
		
		User user = new User();
		user.setName(name);
		user.setAge(age);
		return user;
		
	}


	// POST 방식 처리에 대한 Valid 확인 (반드시 Valid를 지정해주어야 한다.)
	@PostMapping("/user")
	public ResponseEntity<?> user(@Valid @RequestBody User user, BindingResult bindingResult) {

		// 예전 방식 - 방어적 코드
		if (user.getAge() < 1 || user.getAge() > 110) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
		}

		// 에러가 발생 시 커스텀하여 프론트 개발자가 잘 처리할 수 있도록 설계해야 한다.
		// BindingResult 가 @Valid에 대한 결과값을 가지고 있다.
		if (bindingResult.hasErrors()) {
			// 에러가 있다면 여기서 처리
			StringBuilder sb = new StringBuilder();
			// 에러가 for문으로 전부 돌게 됨

			bindingResult.getAllErrors().forEach(error -> {

				FieldError field = (FieldError) error;
				String message = field.getDefaultMessage();

				System.out.println("field : " + field.getField());
				System.out.println("message : " + message);

				sb.append("field : " + field.getField() + "\n");
				sb.append("message : " + message + "\n");
				
			});
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
		}

		System.out.println(user);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

}
