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
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.simple.model.dto.BoardDto;
import com.ssafy.simple.model.dto.CommentDto;
import com.ssafy.simple.model.dto.FileDto;
import com.ssafy.simple.model.dto.MemberDto;
import com.ssafy.simple.model.service.BoardService;
import com.ssafy.simple.model.service.CommentService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;

	@Autowired
	private CommentService commentService;

//	@GetMapping("/list")
//	public ModelAndView list() throws SQLException {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("/list");
//		mv.addObject("boardList", service.list());
//		return mv;
//	}

	@GetMapping("/list")
	public ModelAndView list() {
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
		MemberDto user = (MemberDto) session.getAttribute("loginInfo");
		if (user == null) {
			return "/loginCheck";
		}
		return "/write";
	}

	@PostMapping("/write")
	public String write(BoardDto dto, MultipartFile[] uploadedFiles, HttpSession session)
			throws SQLException, IllegalStateException, IOException {

		MemberDto user = (MemberDto) session.getAttribute("loginInfo");

		if (user == null) {
			return "/loginCheck";
		}

		dto.setBwriter(user.getUserId());
		service.write(dto, uploadedFiles);

		return "redirect:list";
	}

	@GetMapping("/read")
	public String read(int bno, HttpSession session, Model model) throws SQLException {

		MemberDto user = (MemberDto) session.getAttribute("loginInfo");

		if (user == null) {
			return "loginCheck";
		}

		model.addAttribute("board", service.read(bno));
		model.addAttribute("comments", commentService.loadAllComment(bno));

		return "read";
	}

	@GetMapping("/remove")
	public String remove(int bno, HttpSession session) throws SQLException {

		MemberDto user = (MemberDto) session.getAttribute("loginInfo");

		if (user == null) {
			return "loginCheck";
		}

		service.remove(bno);

		return "redirect:/board/list";
	}

	@GetMapping("/download")
	public void download(int fno, HttpServletResponse resp) throws IOException {
//		제대로 구현하려면 파일 번호를 파라미터로 받아서 DB select한 다음에
//		저장된 파일명과 원래 어떤 이름이었는지 조회해서 진행해야함

		FileDto fileDto = service.getFile(fno);

		String savedPath = fileDto.getSavedPath();
		String originalName = fileDto.getOriginalName();

		resp.setHeader("Content-Disposition",
				"attachment; filename=\"" + new String(originalName.getBytes("UTF-8"), "ISO-8859-1") + "\";");
		resp.setHeader("Content-Transfer-Encoding", "binary");

		File savedFile = new File(savedPath); // c: 드라이브에 저장된 파일 오픈
		FileInputStream fis = new FileInputStream(savedFile);
		OutputStream os = resp.getOutputStream();
		FileCopyUtils.copy(fis, os);
	}

	@PostMapping("/addComment")
	public String addComment(int bno, String comment, HttpSession session) {
		MemberDto member = (MemberDto) session.getAttribute("loginInfo");
		CommentDto dto = new CommentDto();
		dto.setBno(bno);
		dto.setCcontent(comment);
		dto.setCwriter(member.getUserId());

		commentService.addComment(dto);

		return "redirect:/board/read?bno=" + bno;
	}

}
