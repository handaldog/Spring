package com.ssafy.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.board.model.dto.BoardDto;
import com.ssafy.board.model.dto.FileDto;
import com.ssafy.board.model.dto.MemberDto;
import com.ssafy.board.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;

	@GetMapping("/list")
	public ModelAndView list(int page) {
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
	public String write(BoardDto dto, HttpSession session, MultipartFile[] uploadedFiles)
			throws SQLException, IllegalStateException, IOException {

		System.out.println(dto);
		MemberDto user = (MemberDto) session.getAttribute("loginInfo");

		if (user == null) {
			return "/loginCheck";
		}

		dto.setBwriter(user.getUserId());
		service.write(dto, uploadedFiles);
		return "redirect:list?page=1";
	}

	@GetMapping("/read")
	public String read(int bno, HttpSession session, Model model) throws SQLException {

		MemberDto user = (MemberDto) session.getAttribute("loginInfo");

		if (user == null) {
			return "loginCheck";
		}

		model.addAttribute("board", service.read(bno));
		model.addAttribute("comment", service.coList(bno));

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
