package com.kh.semi.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class Member {
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String role;
	private String status;
}
