package com.ssafy.simple.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.simple.model.dto.BoardDto;
import com.ssafy.simple.model.dto.MemberDto;
import com.ssafy.simple.model.service.BoardService;
import com.ssafy.simple.model.service.MemberService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService service;
//	@Autowired
//	private MemberService mservice;

//	@GetMapping("/list")
//	public ModelAndView list() throws SQLException { // 에러 처리 방법 2가지임.
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("list.jsp");
//		mv.addObject("boardList", service.list());
//		return mv;
//	}

	@GetMapping("/list")
	public ModelAndView list(HttpSession session) { // 에러 처리 방법 2가지임.
		MemberDto loginInfo = (MemberDto) session.getAttribute("loginInfo");
		ModelAndView mv = new ModelAndView();
		try {
			//mv.addObject("userid", loginInfo.getUserId());
			mv.addObject("boardList", service.list());
			mv.setViewName("boardlist"); // boardlist.jsp
		} catch (SQLException e) {
			mv.addObject("errorMsg", "글 목록 작업중에 예외가 발생하였습니다.");
			mv.setViewName("error"); // error.jsp
			e.printStackTrace();
		}
		return mv;
	}

	@GetMapping("/write")
	public String write(HttpSession session) {
		MemberDto loginInfo = (MemberDto) session.getAttribute("loginInfo");
		if (loginInfo == null) { // 로그인 안된 사용자는 글쓰기 화면 안줌.
			return "loginCheck"; // 로그인 하라는 alert 띄우고 싶음. 근데 그건 html에 자바스크립트야.
		} else {
			return "write"; // 로그인 된 애는 글쓰기화면 보여주면 됨.
		}
	}

	@PostMapping("/write")
	public String write(BoardDto board, MultipartFile yangfile, HttpSession session)
			throws SQLException, IllegalStateException, IOException {
		// BoardDTO에 파라미터가 담겼는데 제목, 내용만 있음. 작성자는 session에 있는 로그인정보로!
		System.out.println("지금 글쓰기에 첨부되어 업로드되는 파일 : " + yangfile.getName());
		board.setBwriter(((MemberDto) session.getAttribute("loginInfo")).getUserId());

		String savedPath = "c:/SSAFY/upload";
		File savedDir = new File(savedPath);
		if (!savedDir.exists()) {
			savedDir.mkdir(); // 폴더 없으면 생성해라 . 맨 처음 보낸 사람으로 인해 폴터가 생성될 것임.
		}

		String savedName = new Random().nextInt(100000000) + "";
		File savedFile = new File(savedPath + "/" + savedName); // c:/SSAFY/upload/5846971;
		yangfile.transferTo(savedFile);

		service.write(board);
		return "redirect:list";
	}

	@GetMapping("/delete")
	public String delete(int bno) throws SQLException {
		// 여기서 또 검사?? 주소값으로 삭제할 수도 있으니깐?
		service.remove(bno);
		return "redirect:list";
	}

//	@GetMapping("/detail")
//	public String detail(int bno) {
//		service
//	}

}
