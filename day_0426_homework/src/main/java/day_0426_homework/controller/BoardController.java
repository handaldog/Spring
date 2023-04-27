package day_0426_homework.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import day_0426_homework.model.dto.BoardDto;
import day_0426_homework.model.dto.UserDto;
import day_0426_homework.model.service.BoardService;

//@Controller
//@RequestMapping("/board")
@Controller
public class BoardController {

	@Autowired
	private BoardService service;

	@GetMapping("/list")
	@ResponseBody
	public List<BoardDto> list() {

		return ;

	}

	@GetMapping("/write")
	@ResponseBody
	public String insert() {
		return "write";
	}

	@PostMapping("/write")
	@ResponseBody
	public String insert(BoardDto board, HttpSession session) {
		UserDto userInfo = (UserDto) session.getAttribute("loginInfo");
		board.setBwriter(userInfo.getUser_id());
		service.insert(board);
		return "redirect:list";
	}

}
