package com.example.exception3.advice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exception3.dto.CustomError;

@RestControllerAdvice
public class ApiControllerAdvice {
	
	// TODO
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingParam(MissingServletRequestParameterException e) {
		List<CustomError> errorList = new ArrayList<>();
		
		
		System.out.println(e.getParameterName());
		System.out.println(e.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
		
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		List<CustomError> errorList = new ArrayList<>();
		BindingResult bindingResult = e.getBindingResult();
		bindingResult.getAllErrors().forEach(action -> {
			FieldError field = (FieldError)action; //????
			String fieldName = field.getField();
			String message = field.getDefaultMessage();
			CustomError customError = new CustomError();
			customError.setField(fieldName);
			customError.setMessage(message);
			errorList.add(customError);
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}

}
