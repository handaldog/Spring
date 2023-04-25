package com.ssafy.simple.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.simple.model.dto.MemberDto;

@Mapper
public interface MemberMapper {

	public MemberDto selectOne(@Param("id") String id, @Param("pw") String pw);
}
