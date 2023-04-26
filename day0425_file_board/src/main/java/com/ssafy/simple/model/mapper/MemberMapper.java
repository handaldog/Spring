package com.ssafy.simple.model.mapper;

import org.apache.ibatis.annotations.Param;

import com.ssafy.simple.model.dto.MemberDto;

public interface MemberMapper {
	public MemberDto selectOne(@Param("ii") String id, @Param("pp") String pw);
}
