package com.ssafy.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.book.mode.dto.BookDto;
import com.ssafy.book.service.BookService;

////@RestController
////@RequestMapping("/book")
//@Controller
//public class BookController {
//
//	@Autowired
//	private BookService bs;
//
//	// http: // localhost:7777/bookcafe/book
//	@GetMapping("/book")
//	@ResponseBody
//	public List<BookDto> getBooks() {
//		return bs.getBooks();
//	}
//
//	// http: // localhost:7777/bookcafe/book/17
//	@GetMapping("/book/{bbb}")
//	@ResponseBody
//	public BookDto getBook(@PathVariable("bbb") int bno) {
//		return bs.getBook(bno);
//	}
//
//	@PostMapping("/book")
//	@ResponseBody
//	public int addBook(BookDto book) {
//		return bs.add(book);
//	}
//
//	@DeleteMapping("/book")
//	@ResponseBody
//	public int removeBook(int bno) {
//		return bs.remove(bno);
//	}
	
	@RestController
	@RequestMapping("/book")
	public class BookController {

		@Autowired
		private BookService bs;

		// http: // localhost:7777/bookcafe/book
		@GetMapping
		public List<BookDto> getBooks() {
			return bs.getBooks();
		}

		// http: // localhost:7777/bookcafe/book/17
		@GetMapping("/{bbb}")
		public BookDto getBook(@PathVariable("bbb") int bno) {
			return bs.getBook(bno);
		}

		@PostMapping
		public int addBook(BookDto book) {
			return bs.add(book);
		}

		@DeleteMapping
		public int removeBook(int bno) {
			return bs.remove(bno);
		}
}
