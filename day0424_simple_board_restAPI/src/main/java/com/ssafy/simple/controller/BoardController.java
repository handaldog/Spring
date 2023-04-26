package com.ssafy.simple.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.simple.model.dto.BoardDto;
import com.ssafy.simple.model.dto.FileDto;
import com.ssafy.simple.model.dto.MemberDto;
import com.ssafy.simple.model.service.BoardService;

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
			mv.addObject("userid", loginInfo.getUserId());
			mv.addObject("boardList", service.list());
			mv.setViewName("boardlist"); // list.jsp
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
	public String write(BoardDto board, HttpSession session, MultipartFile[] uploadedFiles)
			throws SQLException, IllegalStateException, IOException {
		// BoardDTO에 파라미터가 담겼는데 제목, 내용만 있음. 작성자는 session에 있는 로그인정보로!
		MemberDto loginInfo = (MemberDto) session.getAttribute("loginInfo");
		if (loginInfo == null) { // 로그인 안된 사용자는 글쓰기 화면 안줌.
			return "logincheck"; // 로그인 하라는 alert 띄우고 싶음. 근데 그건 html에 자바스크립트야.
		} else {
			board.setBwriter(loginInfo.getUserId());
			System.out.println("DB에 들어가기 전 boardDto :" + board);

			service.write(board, uploadedFiles); // 지금 작성하는 게시글 번호를 파일에 기록해서 FILE_TB에 넣어야함.
			return "redirect:list";
		}
	}

	@GetMapping("/delete")
	public String delete(int bno) throws SQLException {
		// 여기서 또 검사?? 주소값으로 삭제할 수도 있으니깐?
		service.remove(bno);
		return "redirect:list";
	}

	@GetMapping("/read")
	public ModelAndView read(int bno) throws SQLException {
		ModelAndView mv = new ModelAndView("read");
		service.read(bno);
		mv.addObject("board", service.read(bno)); // boardDto
		return mv;
	}

	@GetMapping("/detail")
	public ModelAndView detail(int bno) {
		System.out.println("detail :" + bno);
		ModelAndView mv = new ModelAndView("detail");
		mv.addObject("board", service.detail(bno));
		mv.addObject("comment", service.coList(bno));
		// System.out.println(service.detail(bno).toString());

		return mv;
	}

	@GetMapping("/download")
	public void download(HttpServletResponse resp, int fno) throws IOException {
		System.out.println(fno);
		// 제대로 구현하려면 파일번호를 파라미터로 받아서 DB select 한 다음에
		// 저장된 파일명과 원래 어떤 이름이었는지 조회해서 진행해야 함.
		FileDto filedto = service.fileinfo(fno);

		// String savedPath = "c:/SSAFY/uploaded";
		String savedPath = filedto.getSaved_path();
		// String originalName = "귀여운 가오나시.jpg";
		String originalName = filedto.getOriginal_name();
		resp.setHeader("Content-Disposition",
				"attachment; filename=\"" + new String(originalName.getBytes("UTF-8"), "ISO-8859-1") + "\";");
//      resp.setHeader("Content-Disposition","attachment; filename=\"귀여운 가오나시.jpg\";");
		resp.setHeader("Content-Transfer-Encoding", "binary");

		File savedFile = new File(savedPath); // c: 드라이브에 저장된 파일 오픈
		FileInputStream fis = new FileInputStream(savedFile);
		OutputStream os = resp.getOutputStream();
		FileCopyUtils.copy(fis, os);
	}

}
