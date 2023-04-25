package com.ssafy.test.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.test.model.dto.AttendanceDto;
import com.ssafy.test.model.service.AttendService;

@Controller
@RequestMapping("/attend")
public class AttendanceController {

	@Autowired
	private AttendService service;

	@GetMapping("/list")
	public ModelAndView list(AttendanceDto product, HttpSession session) throws SQLException {

		List<AttendanceDto> list = service.selectAll();
		String admin = "관리자";
		String stu = "교육생";
		ModelAndView mv = new ModelAndView();
		mv.addObject("attendlist", list);
		mv.addObject("admin", admin);
		mv.addObject("stu", stu);
		mv.setViewName("list");

		return mv;
	}

	@PostMapping("/deleteAll")
	public String removeAll(String[] ano) throws SQLException {
		if (ano != null && ano.length > 0) {
			service.removeAll(ano);
		}
		return "redirect:list";
	}

	@GetMapping("/detail")
	public ModelAndView detailattend(String ano) throws SQLException {
		ModelAndView mv = new ModelAndView("detail");
		mv.addObject("detailattend", service.detail(ano));
		return mv;
	}

	@GetMapping("/regist")
	public String regist() {
		return "regist";
	}

	@PostMapping("/regist")
	public String regist(AttendanceDto attend) throws SQLException {
		System.out.println("상품등록할래포스트");
		service.regist(attend);
		return "redirect:list";
	}
}
