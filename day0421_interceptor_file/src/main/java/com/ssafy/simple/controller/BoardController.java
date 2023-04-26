package com.ssafy.simple.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.simple.model.dto.BoardDto;
import com.ssafy.simple.model.dto.CommentsDto;
import com.ssafy.simple.model.dto.MemberDto;
import com.ssafy.simple.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
//	@GetMapping("/list")
//	public ModelAndView list() throws SQLException {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("/list");
//		mv.addObject("boardList", service.list());
//		return mv;
//	}
	
	@GetMapping("/list")
	public ModelAndView list(){
		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("boardList", service.list());
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

		return "/write";
	}
	
	@PostMapping("/write")
	public String write(BoardDto dto, MultipartFile uploadFile, HttpSession session) throws SQLException, IllegalStateException, IOException {
		System.out.println("첨부파일 : " + uploadFile.getOriginalFilename());
		MemberDto user = (MemberDto) session.getAttribute("loginInfo");
		dto.setBwriter(user.getUserId());
		
		String savedPath = "c:/MyStorage/uploaded";
		File savedDir = new File(savedPath);
		
		if(!savedDir.exists()) {
			savedDir.mkdir();
		}
			
		String savedName = new Random().nextInt(100000000)+uploadFile.getOriginalFilename();
		File savedFile = new File(savedPath+"/"+savedName);
		uploadFile.transferTo(savedFile);
		
		service.write(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/read")
	public String read(int bno, HttpSession session, Model model) throws SQLException {
		
		BoardDto board = service.read(bno);
		model.addAttribute("board", board);
		
		return "read";
	}
	
	@GetMapping("/remove")
	public String remove(int bno, HttpSession session) throws SQLException {
		
		service.remove(bno);
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/comments")
	public String comments(int bno, String comment, HttpSession session) throws SQLException {
		MemberDto member = (MemberDto) session.getAttribute("loginInfo");
		CommentsDto dto = new CommentsDto();
		dto.setBno(bno);
		dto.setContent(comment);
		dto.setUserId(member.getUserId());
		
		service.writeComment(dto);
		
		return "redirect:/board/read?bno="+bno;
	}
}
