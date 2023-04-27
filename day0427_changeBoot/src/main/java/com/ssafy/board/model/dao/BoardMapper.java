package com.ssafy.board.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.board.model.dto.BoardDto;

@Mapper
public interface BoardMapper {
	
	public int insert(BoardDto board);
	public int delete(int bno);
	public List<BoardDto> select(int startRow);
	public List<BoardDto> selectAll();
	public BoardDto selectOne(int bno);
	public int selectTotalCount();
	
}
