package com.kh.study.notice.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.study.notice.model.dao.NoticeMapper;
import com.kh.study.notice.model.dto.NoticeDto;

@Service
// @RequiredArgsConstructor
public class NoticeService {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	public List<NoticeDto> findAll(){
		return noticeMapper.findAll();
	}
	
	public NoticeDto findById(Long noticeNo) {
		return noticeMapper.findById(noticeNo);
	}

	public void save(NoticeDto notice) {
		noticeMapper.save(notice);
	}
	 
}
