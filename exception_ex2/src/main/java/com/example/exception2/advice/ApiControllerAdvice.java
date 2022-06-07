package com.example.exception2.advice;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exception2.dto.CustomError;

@RestControllerAdvice
public class ApiControllerAdvice {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e) {
		System.out.println("예외 발생");
		System.out.println("===================================");
		System.out.println(e.getClass());
		System.out.println("===================================");
		System.out.println(e.getMessage());
		System.out.println("===================================");
		System.out.println(e.getCause());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}

	// MissingServletRequestParameterException 예외 발생 -->
	// GET 방식일 때 넘어오는 파라미터 없을 경우 발생한다.
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e) {
		System.out.println("MissingServletRequestParameterException 오류 발생!");

		String fieldName = e.getParameterName();
		String fieldType = e.getParameterType();
		String invalidValue = e.getMessage();

		System.out.println("fieldName : " + fieldName);
		System.out.println("fieldType" + fieldType);
		System.out.println("invalidValue" + invalidValue);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldName + "을 입력해야 합니다.");
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		System.out.println("methodArgumentNotValidException 예외 발생");

		// 한번에 전부 들어온다.
		// get 방식은 하나가 오류가 나면 그 다음 처리 X, 그러나 post 방식은 body안에 한번에 들어오기 때문에 list이다.
		// 다 처리된다.
		// list 구조로 들어온다는 뜻
		List<CustomError> errorList = new ArrayList<>();
		BindingResult bindingResult = e.getBindingResult();
		bindingResult.getAllErrors().forEach(action -> {
			// action
			FieldError field = (FieldError)action;
			String fieldName = field.getField();
			String message = field.getDefaultMessage();
			
			CustomError customError = new CustomError();
			customError.setField(fieldName);
			customError.setMessage(message);
			
			errorList.add(customError);
			
//			System.out.println("action : " + action.toString());
		});

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);

	}
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<?> constraintViolationException(ConstraintViolationException e) {
		// 동시에 validation 확인됨.
		System.out.println("constraintViolationException 예외 발생!");
		List<CustomError> errorList = new ArrayList<>();
		e.getConstraintViolations().forEach(error -> {
			// getBindingResult 없음
			String strField = error.getPropertyPath().toString();
			int index = strField.indexOf(".");
			
			String fieldName = strField.substring(index + 1);
			String message = error.getMessage();
			
			CustomError customError = new CustomError();
			customError.setField(fieldName);
			customError.setMessage(message);
			errorList.add(customError);
//			System.out.println(strField);
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}
	
	

}
