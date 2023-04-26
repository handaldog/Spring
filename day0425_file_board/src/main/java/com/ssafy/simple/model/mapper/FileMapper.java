package com.ssafy.simple.model.mapper;

import java.util.List;

import com.ssafy.simple.model.dto.FileDto;

public interface FileMapper {
	int insert(FileDto f);
	List<FileDto> selectList(int bno);
	FileDto selectOne(int fno);
}
