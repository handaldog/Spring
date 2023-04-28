package com.ssafy.board.model.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.board.model.dao.BoardMapper;
import com.ssafy.board.model.dao.CommentMapper;
import com.ssafy.board.model.dao.FileMapper;
import com.ssafy.board.model.dto.BoardDto;
import com.ssafy.board.model.dto.CommentDto;
import com.ssafy.board.model.dto.FileDto;

@Service
public class BoardService {

	@Autowired
	private BoardMapper dao;

	@Autowired
	private CommentMapper cm;

	@Autowired
	private FileMapper fm;

	@Transactional
	public int write(BoardDto boardDto, MultipartFile[] uploadedFiles) throws SQLException, IllegalStateException, IOException {
		
		int result = dao.insert(boardDto);

		String dirPath = "c:/ssafy/upload";
		File dir = new File(dirPath);
		if (!dir.exists()) {
			dir.mkdir();
		}

		System.out.println(uploadedFiles.length);

		for (MultipartFile file : uploadedFiles) {
			String savedName = new Random().nextInt(12323141) + "";
			File savedFile = new File(dirPath + "/" + savedName);
			file.transferTo(savedFile);

			FileDto dto = new FileDto();
			dto.setOriginal_name(file.getOriginalFilename());
			dto.setBno(boardDto.getBno());
			dto.setSaved_path(savedFile.getAbsolutePath());
			fm.insert(dto);
		}

		return result;

	}

	public int remove(int bno) throws SQLException {
		return dao.delete(bno);
	}

	public Map<String, Object> list(int curPage) throws SQLException {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("curPage", curPage);

		int startPage = (curPage - 1) / 10 * 10 + 1;
		pageMap.put("startPage", startPage);

		int totalBoardCount = dao.selectTotalCount(); // 전체 게시글 수
		int totalPage = totalBoardCount / 10; // 전체 게시글 페이지 수
		if (totalBoardCount % 10 > 0) {
			totalPage++; // 나머지계산
		}
		pageMap.put("totalPage", totalPage);

		int endPage = startPage + 9;
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		pageMap.put("endPage", endPage);

		int startRow = (curPage - 1) * 10; // 1페이지 : 0~9, 2페이지: 10~19...
		List<BoardDto> boardList = dao.select(startRow);
		pageMap.put("boardList", boardList);

		return pageMap;

	}

	@Transactional
	public BoardDto read(int bno) throws SQLException {
		BoardDto board = dao.selectOne(bno);
		return board;
	}

	public FileDto fileinfo(int fno) {
		return fm.selectOne(fno);
	}

	public int coWrite(CommentDto cdto) {
		return cm.coinsert(cdto);
	}

	public List<CommentDto> coList(int bno) {
		return cm.coSelectAll(bno);
	}

}
