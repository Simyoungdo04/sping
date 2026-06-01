package com.kh.study.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.study.member.model.dao.MemberMapper;
import com.kh.study.member.model.dto.MemberDto;

@Service
public class MemberService {

	@Autowired
	private MemberMapper mapper;
	
	public List<MemberDto> findAll(){
		return mapper.findAll();
	}

	public MemberDto findById(String userId) {
		return mapper.findById(userId);
	}
	
}
