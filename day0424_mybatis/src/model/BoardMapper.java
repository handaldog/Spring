package model;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BoardMapper { // SQL 실행을 위한 목적. (기존에 DAO로 불리던 클래스 대체)

	public int insert(BoardDto board);

	public BoardDto selectOne(@Param("id") String id, @Param("pw") String pw);

	public List<BoardDto> selectAll();

}
