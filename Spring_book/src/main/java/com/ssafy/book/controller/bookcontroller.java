package com.ssafy.book.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.book.model.dto.bookdto;
import com.ssafy.book.model.service.bookservice;

@Controller // 혼자 왕따임.
public class bookcontroller {

	@Autowired
	private bookservice service;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	// @RequestMapping(value = "/list", method = RequestMethod.GET)
	@GetMapping("/list")
	public ModelAndView list() throws SQLException {
		ModelAndView mv = new ModelAndView("booklist"); // jsp 이름
		mv.addObject("books", service.getAll());
		return mv;
	}

	@GetMapping("/write")
	public String write() {
		return "bookwrite";
	}

	@PostMapping("/write")
	public String write(bookdto book) throws SQLException { // 4개의 파라미터를 get해서 알아서 dto에 set, set,, 으로 넣어줌.
		if (service.add(book)) {
			return "add_success"; // redirect 로 하면 안되나?
		} else {
			return "add_fail";
		}

	}

	@GetMapping("/delete")
	public String delete(int bno) throws SQLException {
		service.remove(bno);
		return "redirect:list";
	}

	@PostMapping("/deleteAll")
	public String removeAll(int[] bno) throws SQLException {
		if (bno != null && bno.length > 0) {
			service.removeAll(bno);
		}
		return "redirect:list";
	}

	@GetMapping("/detail")
	public ModelAndView detailbook(int bno) throws SQLException {
		ModelAndView mv = new ModelAndView("bookdetail");
		mv.addObject("book", service.detail(bno));
		return mv;
	}

	@GetMapping("/modify")
	public String modifybook(int bno) {
		return "bookmodify";
	}

	@PostMapping("/modify")
	public ModelAndView modify() {
		ModelAndView mv = new ModelAndView("/bookmodify")
	}

}
