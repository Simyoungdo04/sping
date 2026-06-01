package com.kh.study.member.model.dto;

public class MemberDto {
	private String userId;
	private String userName;
	private String email;
	private String userPwd;
	private String status;
	private String enrollDate;
	private String modifyDate;
	public MemberDto() {
		super();
	}
	public MemberDto(String userId, String userName, String email, String userPwd, String status, String enrollDate,
			String modifyDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.userPwd = userPwd;
		this.status = status;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "MemberDto [userId=" + userId + ", userName=" + userName + ", email=" + email + ", userPwd=" + userPwd
				+ ", status=" + status + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + "]";
	}
	
	
}
