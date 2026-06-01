package com.kh.study.cafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.study.cafe.service.CafeService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cafes")
public class CafeController {
	
	@Autowired
	private CafeService service;
	
	@GetMapping
	public String getRes(@RequestParam(value="page") int page) {
		return service.getRes(page);
	}
	
}
