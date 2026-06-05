package com.kh.semi.board.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import com.kh.semi.board.model.dto.BoardDto;
import com.kh.semi.board.model.vo.Board;

@Mapper
public interface BoardMapper {
	
	void save(Board b);
	
	List<BoardDto> findAll(RowBounds rb);

	BoardDto findByBoardNo(Long boardNo);

	void deleteByBoardNo(Long boardNo);

	void update(BoardDto board);
}
