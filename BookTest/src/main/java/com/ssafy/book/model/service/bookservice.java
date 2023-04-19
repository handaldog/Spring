package com.ssafy.book.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssafy.book.model.dao.bookdao;

@Component
public class bookservice {

	@Autowired
	private bookdao dao;
}
