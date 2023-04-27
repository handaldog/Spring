package com.ssafy.book.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.book.model.dto.Book;
import com.ssafy.book.model.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
//	@RequestMapping(value="/list", method=RequestMethod.GET)
	@GetMapping("/list")
	public ModelAndView list() throws SQLException {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("booklist"); // /WEB-INF/views/booklist.jsp
		ModelAndView mv = new ModelAndView("booklist");
		mv.addObject("books", service.getAll());
		
		return mv;
	}
	
	@GetMapping("/write")
	public String write() {
		return "bookwrite"; // /WEB-INF/views/bookwrite.jsp
	}
	
	@PostMapping("/write")
	public String write(Book book) throws SQLException {	// 4개의 파라미터를 알아서 dto에 set 하여 보여줌
		if(service.add(book)) {
			return "add_success";
		}
		else {
			return "add_fail";
		}
	}
	
	@GetMapping("/delete") 
	public String delete(int bno) throws SQLException {
		service.remove(bno);
		
//		return "booklist"; // 이러면 데이터가 jsp로 가지 않음
		return "redirect:list";
	}
	
	@PostMapping("/deleteAll")
	public String deleteAll(int[] bno) throws SQLException {
		service.removeAll(bno);
		
		return "redirect:list";
	}
	
	@GetMapping("/detail")
	public ModelAndView detail(int bno) throws SQLException {
		ModelAndView mv = new ModelAndView("bookdetail");
		mv.addObject("book", service.getOne(bno));
		
		return mv;
	}
	
	@GetMapping("/modify")
	public ModelAndView modify(int bno) throws SQLException {
		ModelAndView mv = new ModelAndView("bookmodify");
		mv.addObject("book", service.getOne(bno));
		
		return mv;
	}
	
	@PostMapping("/modify")
	public String modify(Book book) throws SQLException {
		
		service.modify(book);
		
		return "redirect:detail?bno="+book.getBno();
	}
}
