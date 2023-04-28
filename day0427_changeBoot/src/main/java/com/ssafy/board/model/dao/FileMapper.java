package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.FileDto;



public interface FileMapper {
	
	int insert(FileDto f);
	
	List<FileDto> selecList(int bno);
	
	FileDto selectOne(int fno);
	
}
