package com.ssafy.product.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.product.model.dto.memberDto;
import com.ssafy.product.model.service.memberService;

@Controller
@RequestMapping("/user")
public class memberController {

	@Autowired
	private memberService service;

	@PostMapping("/login")
	public String login(String userId, String userPw, HttpSession session) throws SQLException {
		memberDto userInfo = service.login(userId, userPw);
		if (userInfo != null) {
			session.setAttribute("logininfo", userInfo);
			System.out.println("1213232");
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
