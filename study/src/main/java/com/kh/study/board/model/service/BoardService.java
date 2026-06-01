package com.kh.study.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.study.board.model.dao.BoardMapper;
import com.kh.study.board.model.dto.BoardDto;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	public List<BoardDto> findAll(){
		return mapper.findAll();
	}
	
}
