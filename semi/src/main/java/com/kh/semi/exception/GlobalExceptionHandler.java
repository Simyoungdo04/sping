package com.kh.semi.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kh.semi.exception.model.dto.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomAuthenticationException.class)
	public ResponseEntity<ErrorResponse> handlerAuthenticationError(CustomAuthenticationException e){
		return ResponseEntity.badRequest().body(new ErrorResponse(400, e.getMessage(), null));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handlerArgumentsNotValid(MethodArgumentNotValidException e){
		/*
		List<FieldError> list = e.getBindingResult().getFieldErrors();
		for(FieldError err : list) {
			log.info("예외 발생 필드명 : {}, 발생한 이유 : {}", err.getField(), err.getDefaultMessage());
		}
		*/
		Map<String, String> errors = new HashMap();
		e.getBindingResult().getFieldErrors().forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
		return ResponseEntity.badRequest().body(new ErrorResponse(400, "유효하지 않은 요청입니다.", errors));
	}
	
	@ExceptionHandler(DuplicateMemberIdException.class)
	public ResponseEntity<ErrorResponse> handlerDuplicateId(DuplicateMemberIdException e){
		ErrorResponse er = new ErrorResponse(400, e.getMessage(), null);
		return ResponseEntity.badRequest().body(er);
	}
	
	@ExceptionHandler(FailSignUpException.class)
	public ResponseEntity<ErrorResponse> handlerFailSignUp(FailSignUpException e){
		return ResponseEntity.internalServerError().body(new ErrorResponse(500, e.getMessage(), null));
	}
	
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlerUserNameNotFound(UsernameNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(404, "존재하지 않는 자원", null));
	}
	
}
