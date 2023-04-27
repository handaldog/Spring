package com.ssafy.simpleboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.simpleboard.model.dto.MemberDto;

@Component
public class LoginInterceptor implements HandlerInterceptor {	// 공통 관심 사항 구현 클래스 (객체로 만들어서 스프링한테 들어가야 거기있는 애들 겐세이)
	
	// boolean return -> true : controller로 이행 가능 (검사 조건 만족), false : 컨트롤러 진행을 취소 (검사 조건 불만족)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		MemberDto loginInfo = (MemberDto) session.getAttribute("loginInfo");
		
		if (loginInfo == null) {
			
			request.getRequestDispatcher("/WEB-INF/views/loginCheck.jsp").forward(request, response);
			return false;
		}
		
		return true;
	}
}
