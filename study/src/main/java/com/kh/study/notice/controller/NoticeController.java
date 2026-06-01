package com.kh.study.notice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.study.notice.model.dto.NoticeDto;
import com.kh.study.notice.model.service.NoticeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/api/notices")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping
	public List<NoticeDto> findAll(){
		return noticeService.findAll();
	}
	
	@GetMapping("/{id}")
	public NoticeDto noticeService(@PathVariable(name="id") Long boardNo) {
		return noticeService.findById(boardNo);
	}
	
	@PostMapping
	public Map<String, String> save(@RequestBody NoticeDto notice) {
		noticeService.save(notice);
		return Map.of("success", "성공");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
