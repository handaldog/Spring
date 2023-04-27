package day_0426_homework.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import day_0426_homework.model.dto.UserDto;
import day_0426_homework.model.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/login")
	public String login(String user_id, String user_pw, HttpSession session) {
		UserDto userInfo = service.login(user_id, user_pw);

		if (userInfo != null) {
			session.setAttribute("userInfo", userInfo);
			return "index";
		}
		return "index";

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
}
