package com.kh.study.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kh.study.util.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException e){
		// System.out.println(e.getBindingResult().getFieldError());
		Map<String, String> errors = new HashMap();
		e.getBindingResult().getFieldErrors().forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
		ErrorResponse er = new ErrorResponse(4, "잘못된 파라미터", errors);
		return ResponseEntity.badRequest().body(er);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException e){
		ErrorResponse er = new ErrorResponse(44, e.getMessage(),null);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
