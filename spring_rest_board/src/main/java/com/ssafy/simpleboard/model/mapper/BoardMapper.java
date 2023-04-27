package com.ssafy.simpleboard.model.mapper;

import java.util.List;

import com.ssafy.simpleboard.model.dto.BoardDto;

public interface BoardMapper {
	
	public int insert(BoardDto board);
	public int delete(int bno);
	public List<BoardDto> select(int startRow);
	public List<BoardDto> selectAll();
	public BoardDto selectOne(int bno);
	public int selectTotalCount();
	
}
