package com.kh.study.reply.medel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.study.reply.medel.dao.ReplyMapper;
import com.kh.study.reply.medel.dto.ReplyDto;

@Service
public class ReplyService {
	
	@Autowired
	private ReplyMapper mapper;
	
	public List<ReplyDto> findAll(){
		return mapper.findAll();
	}
}
