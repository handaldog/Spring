package day_0426_homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import day_0426_homework.model.dto.BoardDto;

@Controller
public class BoardController {
	
	@GetMapping
	public String insert(BoardDto board) {
		return "redirect:detail";
	}

}
