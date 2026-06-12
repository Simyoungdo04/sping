package com.kh.semi.admin.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/admin")
@Slf4j
public class AdminController {

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public String findAllMembers() {
		log.info("aaaaa");
		return "회원 전체 정보";
	}
	
}
