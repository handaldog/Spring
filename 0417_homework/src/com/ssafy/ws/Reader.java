package com.ssafy.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Reader {

//	@Autowired // 필드에 주입하는 방법
//	@Qualifier("comicBook")
//	private Book book;

//	private Book book;
//
//	@Autowired // setter에 주입하는 방법
//	public void setBook(@Qualifier("comicBook") Book book) {
//		this.book = book;
//	}

//	@Autowired // 생성자에 주입하는 방법
//	public Reader(@Qualifier("comicBook") Book book) {
//		this.book = book;
//	}

//	public void read() {
//		System.out.println(book.getInfo() + "을(를) 열심히 읽습니다.");
//	}

}
