package com.ssafy.basic;

import java.util.Arrays;

// DTO는 스프링이 관리하면 안됨. 어노테이션같은거 쓰면 안됨.
public class ParamDto {

	private String userId;
	private String userName;
	private String[] fruit;

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

	public String[] getFruit() {
		return fruit;
	}

	public void setFruit(String[] fruit) {
		this.fruit = fruit;
	}

	@Override
	public String toString() {
		return "ParamDto [userId=" + userId + ", userName=" + userName + ", fruit=" + Arrays.toString(fruit) + "]";
	}

}
