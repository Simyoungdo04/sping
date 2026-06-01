package com.kh.task.user.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
	private Long userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String role;
	private Date createDate;
	private String status;
}
