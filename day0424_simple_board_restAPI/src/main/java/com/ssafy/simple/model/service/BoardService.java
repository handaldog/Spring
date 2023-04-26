package com.ssafy.simple.model.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.simple.model.dao.BoardMapper;
import com.ssafy.simple.model.dao.CommentMapper;
import com.ssafy.simple.model.dao.FileMapper;
import com.ssafy.simple.model.dto.BoardDto;
import com.ssafy.simple.model.dto.CommentDto;
import com.ssafy.simple.model.dto.FileDto;

@Service
public class BoardService {

	@Autowired
	private BoardMapper bm;

	@Autowired
	private FileMapper fm;

	@Autowired
	private CommentMapper cm;

	@Transactional
	public int write(BoardDto board, MultipartFile[] uploadedFiles)
			throws SQLException, IllegalStateException, IOException {

		int result = bm.insert(board);

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
			dto.setBno(board.getBno());
			dto.setSaved_path(savedFile.getAbsolutePath());
			fm.insert(dto);
		}

		return result;

	}

	public BoardDto read(int bno) throws SQLException {
		BoardDto board = bm.selectOne(bno);
		board.setFiles(fm.selecList(bno));
		return board;

	}

	public int remove(int bno) throws SQLException {
		return bm.delete(bno);
	}

	public List<BoardDto> list() throws SQLException {
		return bm.selectAll();
	}

	public BoardDto detail(int bno) {
		BoardDto board = bm.selectOne(bno);
		board.setFiles(fm.selecList(bno));
		System.out.println(board.toString());
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
