package com.ssafy.test.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.test.model.dto.UserInfoDto;
import com.ssafy.test.model.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/login")
	public String login(String userId, String userPw, HttpSession session) throws SQLException {
		UserInfoDto userInfo = service.login(userId, userPw);
		
		if (userInfo != null) {
			session.setAttribute("logininfo", userInfo);
			System.out.println(userInfo.toString());
			return "regist";
		} else {
			System.out.println(515454);
			ModelAndView mv = new ModelAndView();
			mv.addObject("msg", "id또는 패스워드를 확인하세요.");
			mv.setViewName("index.jsp");
		}
		return "index";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
}
