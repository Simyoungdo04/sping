package com.kh.study.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.study.member.model.dto.MemberDto;
import com.kh.study.member.model.service.MemberService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/members")
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping
	public List<MemberDto> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public MemberDto findById(@PathVariable(name="id") String userId) {
		return service.findById(userId);
	}
	
}
