package com.ssafy.board.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.board.model.dto.BoardDto;
import com.ssafy.board.model.dto.MemberDto;
import com.ssafy.board.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	
	@GetMapping("/list")
	public ModelAndView list(int page){
		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("boardPage", service.list(page));
			mv.setViewName("/list");
		} catch (SQLException e) {
			e.printStackTrace();
			mv.addObject("msg", "리스트를 불러오던 중 에러가 발생하였습니다");
			mv.setViewName("/error/error");
		}
		return mv;
	}
	
	@GetMapping("/write")
	public String write(HttpSession session) {
		MemberDto user = (MemberDto) session.getAttribute("loginInfo");
		if (user == null) {
			return "/loginCheck";
		}
		return "/write";
	}
	
	@PostMapping("/write")
	public String write(BoardDto dto, HttpSession session) throws SQLException {
		
		System.out.println(dto);
		MemberDto user = (MemberDto) session.getAttribute("loginInfo");
		
		if (user == null) {
			return "/loginCheck";
		}
		
		dto.setBwriter(user.getUserId());
		service.write(dto);
		
		return "redirect:list?page=1";
	}
	
	@GetMapping("/read")
	public String read(int bno, HttpSession session, Model model) throws SQLException {
		
		MemberDto user = (MemberDto) session.getAttribute("loginInfo");
		
		if (user == null) {
			return "loginCheck";
		}
		
		model.addAttribute("board", service.read(bno));
		
		return "read";
	}
	
	@GetMapping("/remove")
	public String remove(int bno, HttpSession session) throws SQLException {
		
		MemberDto user = (MemberDto) session.getAttribute("loginInfo");
		
		if (user == null) {
			return "loginCheck";
		}
		
		service.remove(bno);
		
		return "redirect:/list?page=1";
	}
	
}
