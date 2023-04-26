package com.ssafy.simple.model.mapper;

import java.util.List;

import com.ssafy.simple.model.dto.BoardDto;

public interface BoardMapper {
	
	public int insert(BoardDto board);
	public int delete(int bno);
	public List<BoardDto> selectAll();
	public BoardDto selectOne(int bno);
	
}
