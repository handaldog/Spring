package com.ssafy.simple.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.simple.model.dto.CommentDto;
import com.ssafy.simple.model.dto.MemberDto;
import com.ssafy.simple.model.service.BoardService;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private BoardService service;

	@GetMapping("/wcomment") // modelandview 리턴 아님 주의 !! 나는 REST라서 View 안옴. data만 줌

	public List<CommentDto> getcomment(int bno) {
		
		return service.coList(bno);
	}

	@PostMapping("/wcomment")

	public String setcomment(int bno, CommentDto cdto, HttpSession session) {
		cdto.setBno(bno);

		MemberDto loginInfo = (MemberDto) session.getAttribute("loginInfo");
		// System.out.println(loginInfo.getUserId());
		cdto.setCwriter(loginInfo.getUserId());
		System.out.println(cdto.toString());
		service.coWrite(cdto);
		return "redirect:/board/detail?bno=" + bno;
	}

}
