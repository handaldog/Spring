package com.ssafy.simple.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.simple.model.dao.BoardDao;

import com.ssafy.simple.model.dto.BoardDto;

@Service
public class BoardService {
	@Autowired
	private BoardDao dao;

	public int write(BoardDto board) throws SQLException {
		return dao.insert(board);
	}

	public BoardDto read(int bno) throws SQLException {
		return dao.selectOne(bno);
	}

	public int remove(int bno) throws SQLException {
		return dao.delete(bno);
	}

	public List<BoardDto> list() throws SQLException {
		return dao.selectAll();
	}
}
