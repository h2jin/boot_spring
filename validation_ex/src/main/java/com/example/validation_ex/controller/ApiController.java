package com.example.validation_ex.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation_ex.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {

	@PostMapping("/user")
	public ResponseEntity<?> user(@Valid @RequestBody User user, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			bindingResult.getAllErrors().forEach(error -> {
				FieldError field = (FieldError) error; // 다운캐스팅
				String errorMessage = field.getDefaultMessage();

				sb.append("field : " + field + "\n");
				sb.append("errorMessage : " + errorMessage + "\n");

			});

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
		}
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

}
