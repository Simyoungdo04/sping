package com.kh.study.board.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.study.board.model.dto.BoardDto;

@Mapper
public interface BoardMapper {

	@Select("SELECT * FROM BOARD WHERE STATUS = 'Y'")
	public List<BoardDto> findAll();
	
}
