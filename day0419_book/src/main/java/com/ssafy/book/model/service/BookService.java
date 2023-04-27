package com.ssafy.book.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.book.model.dao.BookDao;
import com.ssafy.book.model.dto.Book;

@Service
public class BookService {
	
	// @Autowired
	private final BookDao dao;
	
	// 생성자 방식 주입
	private BookService(BookDao dao) {
		this.dao = dao;
	}
	
	
	public boolean add(Book book) throws SQLException {
		if (dao.insert(book) > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<Book> getAll() throws SQLException {
		return dao.selectAll();
	}
	
	public void remove(int bno) throws SQLException {
		dao.delete(bno);
	}


	public void removeAll(int[] bno) throws SQLException {
		if (bno.length == 0) return;
		
		for(int bn : bno) {
			dao.delete(bn);
		}
	}
	
	public void modify(Book book) throws SQLException {
		dao.update(book);
	}
	
	public Book getOne(int bno) throws SQLException {
		return dao.select(bno);
	}
	
}
