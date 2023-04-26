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

import com.ssafy.simple.model.dao.BoardDao;
import com.ssafy.simple.model.dto.BoardDto;
import com.ssafy.simple.model.dto.FileDto;
import com.ssafy.simple.model.mapper.BoardMapper;
import com.ssafy.simple.model.mapper.FileMapper;

@Service
public class BoardService {

	@Autowired
	private BoardMapper dao;
	@Autowired
	private FileMapper fileDao;

	@Transactional
	public int write(BoardDto boardDto, MultipartFile[] uploadedFiles) throws SQLException, IllegalStateException, IOException {
		dao.insert(boardDto);
		
		String dirPath = "c:/SSAFY/upload";
		File dir= new File(dirPath);
		if(!dir.exists()) 
			dir.mkdir();
		
		for(MultipartFile file : uploadedFiles) {
			
			if(file == null || file.getOriginalFilename().equals("")) continue;
			
			String savedName = new Random().nextInt(1000000000) + file.getOriginalFilename();
			File savedFile = new File(dirPath+"/"+savedName);
			file.transferTo(savedFile);
			
			FileDto fileDto = new FileDto();
			fileDto.setOriginalName(file.getOriginalFilename());
			fileDto.setSavedPath(savedFile.getAbsolutePath());
			fileDto.setBno(boardDto.getBno());
			
			fileDao.insert(fileDto);
		}
		
		return 1;
	}
	
	public int remove(int bno) throws SQLException {
		return dao.delete(bno);
	}
	
	public List<BoardDto> list() throws SQLException {
		return dao.selectAll();
	}
	
	@Transactional
	public BoardDto read(int bno) throws SQLException {
		BoardDto board = dao.selectOne(bno);
		board.setFiles(fileDao.selectList(bno));
		return board;
	}
	
	public FileDto getFile(int fno) {
		return fileDao.selectOne(fno);
	}
}
