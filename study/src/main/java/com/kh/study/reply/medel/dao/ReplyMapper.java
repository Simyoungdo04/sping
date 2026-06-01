package com.kh.study.reply.medel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.study.reply.medel.dto.ReplyDto;

@Mapper
public interface ReplyMapper {
	
	@Select("SELECT * FROM REPLY ORDER BY REPLY_NO DESC")
	List<ReplyDto> findAll();
}
