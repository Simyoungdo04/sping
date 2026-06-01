package com.kh.study.reply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.study.reply.medel.dto.ReplyDto;
import com.kh.study.reply.medel.service.ReplyService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/replies")
public class ReplyController {
	
	@Autowired
	private ReplyService service;
	
	@GetMapping
	public List<ReplyDto> findAll(){
		return service.findAll();
	}
	
}
