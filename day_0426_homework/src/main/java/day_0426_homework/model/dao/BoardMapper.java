package day_0426_homework.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import day_0426_homework.model.dto.BoardDto;

@Mapper
public interface BoardMapper {

	public int insert(BoardDto board);

	public List<BoardDto> selectAll();

	public int delete(int bno);

	public BoardDto selectOne(int bno);
}
