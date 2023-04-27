package day_0426_homework.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import day_0426_homework.model.dao.BoardMapper;
import day_0426_homework.model.dto.BoardDto;

@Service
public class BoardService {

	@Autowired
	private BoardMapper bm;

	public int insert(BoardDto board) {
		return bm.insert(board);
	}

	public List<BoardDto> selectAll() {
		return bm.selectAll();
	}
	
	
}
