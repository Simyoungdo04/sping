package com.kh.semi.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@GetMapping
	public ResponseEntity<String> getTest() {
		return ResponseEntity.ok("응답데이터");
	}

}
