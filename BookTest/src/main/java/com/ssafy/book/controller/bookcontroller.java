package com.ssafy.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.book.model.service.bookservice;

@Controller // 혼자 왕따임.
public class bookcontroller {

	@Autowired
	private bookservice service;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

}
