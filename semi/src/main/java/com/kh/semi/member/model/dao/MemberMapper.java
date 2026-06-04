package com.kh.semi.member.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kh.semi.member.model.vo.Member;

@Mapper
public interface MemberMapper {
	
	@Insert("INSERT INTO SEMI_MEMBER VALUES(#{memberId}, #{memberPwd}, #{memberName}, #{role}, 'Y')")
	int signUp(Member member);

	@Select("SELECT COUNT(*) FROM SEMI_MEMBER WHERE MEMBER_ID = #{memberId}")
	int countByMemberId(String memberId);

	@Update("UPDATE SEMI_MEMBER SET MEMBER_PWD = #{newPassword} WHERE MEMBER_ID = #{username}")
	void changePassword(@Param(value="username") String username, @Param(value="newPassword") String newPassword);
						// Param애노테이션을 사용하면 여러개의 매개변수를 Param의 value에 적은 값으로 키값을 만들어서 하나의 Map으로 전달됨

	@Update("UPDATE SEMI_MEMBER SET STATUS = 'N' WHERE MEMBER_ID = #{username}")
	void deleteByPassword(String username);
}
