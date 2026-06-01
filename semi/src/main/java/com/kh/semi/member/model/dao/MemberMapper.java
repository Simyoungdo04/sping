package com.kh.semi.member.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.semi.member.model.vo.Member;

@Mapper
public interface MemberMapper {
	
	@Insert("INSERT INTO SEMI_MEMBER VALUES(#{memberId}, #{memberPwd}, #{memberName}, #{role}, 'Y')")
	int signUp(Member member);

	@Select("SELECT COUNT(*) FROM SEMI_MEMBER WHERE MEMBER_ID = #{memberId}")
	int countByMemberId(String memberId);
}
