package com.ssafy.simple.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.simple.model.dto.MemberDto;
import com.ssafy.simple.model.service.MemberService;

@Controller
@RequestMapping("/user") // /simple/user/~~~~~인 요청은 일단 이 클래스로 오게
public class MemberController {
	@Autowired
	private MemberService service;

	// 만약 로그인 페이지를 별도로 만들거면 Get로그인도 하나 필요함(난 그냥 헤더에 항상 뜨게 할거라 안만들었음.)
	@PostMapping("/login") // http://localhost:8080/simple/user/login
	public String login(String userId, String userPw, HttpSession session) throws SQLException {
		System.out.println("로그인 들어오냐?"+userId+"/"+userPw);
		MemberDto loginInfo = service.login(userId, userPw);
		System.out.println(loginInfo);
		System.out.println(loginInfo.toString());
		if (loginInfo != null) { // login success
			System.out.println("null이 아니니?");
			session.setAttribute("loginInfo", loginInfo);
		}
		return "index"; // 로그인 성공 실패시 보여줄 화면이 다르다면 return값이 달라져야 될 수 있음.
	}

	@GetMapping("/logout") // http://localhost:8080/simple/user/logout
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}

}
