package day_0426_homework.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import day_0426_homework.model.dao.BoardMapper;
import day_0426_homework.model.dto.BoardDto;

public class BoardService {

	@Autowired
	private BoardMapper bm;

	public int insert(BoardDto board) {
		return bm.insert(board);
	}
}
