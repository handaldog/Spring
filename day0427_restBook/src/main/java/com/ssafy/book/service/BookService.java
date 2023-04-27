package com.ssafy.book.service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.book.mode.dto.BookDto;
import com.ssafy.book.model.repository.BookMapper;

@Service
public class BookService {

	@Autowired
	private BookMapper bm;

	public int add(BookDto b) {
		return bm.insert(b);
	}

	public List<BookDto> getBooks() {
		return bm.selectAll();
	}

	public BookDto getBook(int bno) {
		return bm.selectOne(bno);
	}

	public int remove(int bno) {
		return bm.remove(bno);
	}
}
