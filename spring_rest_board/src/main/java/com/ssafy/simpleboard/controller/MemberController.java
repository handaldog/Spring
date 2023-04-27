package com.ssafy.simpleboard.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.simpleboard.model.dto.MemberDto;
import com.ssafy.simpleboard.model.service.MemberService;

@Controller
@RequestMapping("/user")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@PostMapping("/login")
	public String login(String userId, String userPw, HttpSession session) throws SQLException {
		MemberDto loginInfo = service.login(userId, userPw);
		
		if (loginInfo != null) {
			session.setAttribute("loginInfo", loginInfo);
		}
		
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
}
