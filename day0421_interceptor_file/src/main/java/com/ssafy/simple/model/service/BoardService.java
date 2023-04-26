package com.ssafy.simple.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.simple.model.dao.BoardDao;
import com.ssafy.simple.model.dao.CommentsDao;
import com.ssafy.simple.model.dto.BoardDto;
import com.ssafy.simple.model.dto.CommentsDto;

@Service
public class BoardService {

	@Autowired
	private BoardDao dao;
	
	@Autowired
	private CommentsDao commentDao;

	public int write(BoardDto dto) throws SQLException {
		return dao.insert(dto);
	}
	
	public int remove(int bno) throws SQLException {
		return dao.delete(bno);
	}
	
	public List<BoardDto> list() throws SQLException {
		return dao.selectAll();
	}
	
	public BoardDto read(int bno) throws SQLException {
		BoardDto dto = dao.selectOne(bno);
		dto.setComments(commentDao.selectAll(bno));
		return dto;
	}
	
	public int writeComment(CommentsDto comment) throws SQLException {
		return commentDao.insert(comment);
	}
}
