package com.ssafy.simple.model.dao;

import java.util.List;

import com.ssafy.simple.model.dto.FileDto;

public interface FileMapper {
	
	int insert(FileDto f);
	
	List<FileDto> selecList(int bno);
	
}
