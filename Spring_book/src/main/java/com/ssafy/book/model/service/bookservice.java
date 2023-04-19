package com.ssafy.book.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssafy.book.model.dao.bookdao;
import com.ssafy.book.model.dto.bookdto;

@Component
public class bookservice {

	@Autowired
	private bookdao dao;

	public boolean add(bookdto book) throws SQLException {
		if (dao.insert(book) > 0) {
			return true;

		} else {
			return false;
		}

	}

	public List<bookdto> getAll() throws SQLException {
		return dao.selectAll();
	}

	public int remove(int bno) throws SQLException {
		return dao.delete(bno);
	}

	public void removeAll(int[] bno) throws SQLException {
		for (int bn : bno) {
			dao.delete(bn);
		}

	}

	public bookdto detail(int bno) throws SQLException {
		System.out.println(dao.detail(bno).toString());
		return dao.detail(bno);
	}
}
