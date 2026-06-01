package com.kh.study.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.study.board.model.dto.BoardDto;
import com.kh.study.board.model.service.BoardService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/boards")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping
	public List<BoardDto> findAll(){
		return service.findAll();
	}
}
