package com.kh.study.busan.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kh.study.busan.model.dto.ReviewDto;
import com.kh.study.busan.model.dto.UpdateReviewDto;

@Mapper
public interface ReviewMapper {

	@Insert("INSERT INTO REVIEW VALUES(#{ucSeq}, #{content}, SYSDATE, #{rating})")
	public void save(ReviewDto review);
	
	@Select("SELECT * FROM REVIEW WHERE UC_SEQ = #{ucSeq} ORDER BY CREATE_DATE DESC")
	public List<ReviewDto> findBySeq(Long ucSeq);

	@Update("UPDATE REVIEW SET CONTENT = #{updateContent} WHERE UC_SEQ = #{ucSeq} AND CONTENT = #{content}")
	public int update(UpdateReviewDto urd);

	@Delete("DELETE FROM REVIEW WHERE UC_SEQ = #{ucSeq} AND CONTENT = #{content}")
	public void delete(UpdateReviewDto urd);
	
}
