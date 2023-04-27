package com.ssafy.simpleboard.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.simpleboard.model.dto.BoardDto;
import com.ssafy.simpleboard.model.mapper.BoardMapper;

@Service
public class BoardService {

	@Autowired
	private BoardMapper dao;

	@Transactional
	public int write(BoardDto boardDto) throws SQLException {
		dao.insert(boardDto);
		return 1;
	}
	
	public int remove(int bno) throws SQLException {
		return dao.delete(bno);
	}
	
	public Map<String, Object> list(int curPage) throws SQLException {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("curPage", curPage);
		
		int startPage = (curPage-1)/10 * 10 + 1;
		pageMap.put("startPage", startPage);
		
		int totalBoardCount = dao.selectTotalCount();	// 전체 게시글 수
		int totalPage = totalBoardCount/10;	// 전체 게시글 페이지 수
		if (totalBoardCount%10 > 0) {
			totalPage++;	// 나머지계산
		}
		pageMap.put("totalPage", totalPage);
		
		int endPage = startPage + 9;
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		pageMap.put("endPage", endPage);
		
		int startRow = (curPage-1)*10; // 1페이지 : 0~9, 2페이지: 10~19...
		List<BoardDto> boardList = dao.select(startRow);
		pageMap.put("boardList", boardList);
		
		
		return pageMap;

	}
	
	@Transactional
	public BoardDto read(int bno) throws SQLException {
		BoardDto board = dao.selectOne(bno);
		return board;
	}
	
}
