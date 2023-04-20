package com.ssafy.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.member.model.MemberDto;
import com.ssafy.util.PageNavigation;

@Controller
@RequestMapping("/article")
public class BoardController {
	// 왜 오토와이어 안해도 돼?
	private BoardService boardservice;

	public BoardController(BoardService boardservice) { // construct?? bean
		super();
		this.boardservice = boardservice;
	}

	@GetMapping("/write")
	public String write(@RequestParam Map<String, String> map, Model model) { // dto 처럼 쓸수 있어. dto처럼 쓰는 건 뭔데?
		model.addAttribute("pgno", map.get("pgno"));
		model.addAttribute("key", map.get("key"));
		model.addAttribute("word", map.get("word"));
		return "board/write";
	}

	@PostMapping("/write")
	public String write(BoardDto boardto, HttpSession session, RedirectAttributes redi) throws Exception {
		MemberDto memberdto = (MemberDto) session.getAttribute("userinfo");
		boardto.setUserId(memberdto.getUserId());
		boardservice.writeArticle(boardto);
		redi.addAttribute("pgno", "1");
		redi.addAttribute("key", "");
		redi.addAttribute("word", "");

		return "redirect:article/list";
	}

	@GetMapping("/list")
	public ModelAndView list(@RequestParam Map<String, String> map) throws Exception {
		ModelAndView mav = new ModelAndView();

		List<BoardDto> list = boardservice.listArticle(map);
		PageNavigation pageNavigation = boardservice.makePageNavigation(map);
		mav.addObject("articles", list);
		mav.addObject("navigation", pageNavigation);
		mav.addObject("pgno", map.get("pgno"));
		mav.addObject("key", map.get("key"));
		mav.addObject("word", map.get("word"));
		mav.setViewName("/board/list");
		return mav;
	}
}
