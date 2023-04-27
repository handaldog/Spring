package com.ssafy.board.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.board.model.dto.MemberDto;

@Mapper
public interface MemberMapper {
	public MemberDto selectOne(@Param("ii") String id, @Param("pp") String pw);
}
