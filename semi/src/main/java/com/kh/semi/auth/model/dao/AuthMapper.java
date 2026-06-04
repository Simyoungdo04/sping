package com.kh.semi.auth.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.semi.member.model.dto.MemberDto;

@Mapper
public interface AuthMapper {

	@Select("""
				SELECT
					   MEMBER_ID
					 , MEMBER_PWD
					 , MEMBER_NAME
					 , ROLE
					 , STATUS
				  FROM
				  	   SEMI_MEMBER
				 WHERE
				 	   STATUS = 'Y'
				   AND
				   	   MEMBER_ID = #{username}
			""")
	MemberDto loadUser(String username);
	
}
