package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.CommentDto;



public interface CommentMapper {

	public int coinsert(CommentDto cdto);

	public List<CommentDto> coSelectAll(int bno);
}
