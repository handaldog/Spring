package com.ssafy.ws;

import org.springframework.stereotype.Component;

@Component
public class Magazine implements Book{

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "잡지";
	}
	
	

}
