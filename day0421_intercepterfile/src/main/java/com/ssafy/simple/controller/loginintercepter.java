package com.ssafy.simple.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.simple.model.dto.MemberDto;

@Component
public class loginintercepter implements HandlerInterceptor { // 공통관심사항 구현 클래스 (객체로 만들어서 스프링한테 들어가야 거기있는 애들 겐세이)

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberDto loginInfo = (MemberDto) session.getAttribute("loginInfo");

		if (loginInfo == null) { // 로그인 안됐네? 컨트롤러 불가!!
			request.getRequestDispatcher("/WEB-INF/view/logincheck.jsp").forward(request, response);
			return false;
		}
		return true;
	}

}
