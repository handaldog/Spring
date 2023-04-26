package com.ssafy.simple.model.mapper;

import java.util.List;

import com.ssafy.simple.model.dto.CommentDto;

public interface CommentMapper {
	public int insert(CommentDto commentDto);
	public List<CommentDto> selectAll(int bno);
}
