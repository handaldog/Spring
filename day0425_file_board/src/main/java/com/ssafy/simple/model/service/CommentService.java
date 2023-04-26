package com.ssafy.simple.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.simple.model.dto.CommentDto;
import com.ssafy.simple.model.mapper.CommentMapper;

@Service
public class CommentService {
	
	@Autowired
	private CommentMapper dao;
	
	public void addComment(CommentDto commentDto) {
		dao.insert(commentDto);
	}
	
	public List<CommentDto> loadAllComment(int bno) {
		return dao.selectAll(bno);
	}
}
