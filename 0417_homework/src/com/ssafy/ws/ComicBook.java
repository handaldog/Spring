package com.ssafy.ws;

import org.springframework.stereotype.Component;

@Component
public class ComicBook implements Book{

	@Override
	public String getInfo() {
		
		return "만화책";
	}

}
