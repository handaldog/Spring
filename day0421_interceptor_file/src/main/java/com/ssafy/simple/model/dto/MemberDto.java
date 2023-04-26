package com.ssafy.simple.model.dto;

public class MemberDto {
	private String userId; //user_id
	private String userPw; //user_pw
	private String userName; //user_name
	
	public MemberDto() {}	// 기본생성자 반드시 만들어주기!! (라이브러리들이 객체 만들때 사용)

	public MemberDto(String userId, String userPw, String userName) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserPw() {
		return userPw;
	}
	
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "MemberDto [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + "]";
	}
	
}
