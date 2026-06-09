package com.kh.semi.comment.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.semi.comment.model.dto.CommentDto;
import com.kh.semi.comment.model.vo.Comment;

@Mapper
public interface CommentMapper {
	
	@Insert("INSERT INTO SEMI_COMMENT VALUES(SEQ_SCN.NEXTVAL, #{commentWriter}, #{refBoardNo}, #{commentContent}, SYSDATE, 'Y')")
	int save(Comment comment);
	
	@Select("""
				SELECT
					   COMMENT_NO
					 , COMMENT_WRITER
					 , COMMENT_CONTENT
					 , CREATE_DATE
					 , REF_BOARD_NO
				  FROM
				  	   SEMI_COMMENT
				 WHERE
				 	   STATUS = 'Y'
				   AND 
				   	   REF_BOARD_NO = #{boardNo}
				 ORDER
				 	BY
				 	   CREATE_DATE DESC
			""")
	List<CommentDto> findAll(Long boardNo);
	
}
