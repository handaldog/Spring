package com.ssafy.simple.model.dao;

import java.util.List;

import com.ssafy.simple.model.dto.CommentDto;

public interface CommentMapper {

	public int coinsert(CommentDto cdto);

	public List<CommentDto> coSelectAll(int bno);
}
