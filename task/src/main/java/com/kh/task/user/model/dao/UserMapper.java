package com.kh.task.user.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.task.user.model.vo.User;

@Mapper
public interface UserMapper {

	@Insert("INSERT INTO TASK_USER VALUES(UNO_SEQ.NEXTVAL, #{userId}, #{userPwd}, #{userName}, #{role}, SYSDATE, 'Y')")
	int signUp(User user);

	@Select("SELECT COUNT(*) FROM TASK_USER WHERE USER_ID = #{userId}")
	int countById(String userId);
	
}
