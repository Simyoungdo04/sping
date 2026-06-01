package com.kh.study.notice.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.study.notice.model.dto.NoticeDto;

@Mapper
public interface NoticeMapper {
	
	@Select("SELECT * FROM NOTICE ORDER BY NOTICE_NO DESC")
	List<NoticeDto> findAll();
	
	@Select("SELECT * FROM NOTICE WHERE NOTICE_NO = #{noticeNo}")
	NoticeDto findById(Long notionNo);

	@Insert("INSERT INTO NOTICE(NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_WRITER) VALUES(SEQ_MNO,NEXTVAL, #{noticeTitle}, #{noticeContent}, #{noticeWriter}")
	void save(NoticeDto notice);
	
}
