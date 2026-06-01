package com.kh.task.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.task.user.model.dto.UserDto;
import com.kh.task.user.model.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService service;
	
	@PostMapping
	public ResponseEntity<Void> signUp(@RequestBody @Valid UserDto user) {
		service.signUp(user);
		return ResponseEntity.status(201).build();
	}

}
