package com.ssafy.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

@Controller
@RequestMapping("/user")
public class MemberController {

	private MemberService memberService;

	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}

	@GetMapping("/join")
	public String join() {
		return "user/join";
	}

	@GetMapping("/login") // 이거 필요없지 않나?
	public String login() {
		return "user/login";
	}

	@PostMapping("/login") // modelandview로 할려면?
	public String login(@RequestParam("userid") String userId, @RequestParam("userpwd") String userPwd,
			HttpSession session, Model model) throws Exception {
		MemberDto memberdto = memberService.loginMember(userId, userPwd);
		if (memberdto != null) {
			session.setAttribute("userinfo", memberdto);
			return "redirect:/";
		} else {
			model.addAttribute("msg", "아이디 또는 비밀번호가 틀렸습니다.");
			return "user/login"; // 얘는 user을 안 먹나?
		}

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
