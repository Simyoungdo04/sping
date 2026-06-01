package com.kh.task.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kh.task.exception.model.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DuplicateUserIdException.class)
	public ResponseEntity<ErrorResponse> handlerDuplicateId(DuplicateUserIdException e){
		return ResponseEntity.badRequest().body(new ErrorResponse(400, e.getMessage(), null));
	}
	
}
