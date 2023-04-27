package com.ssafy.simpleboard.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.simpleboard.model.dto.MemberDto;
import com.ssafy.simpleboard.model.mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	private MemberMapper dao;
	
	public MemberDto login(String id, String pw) throws SQLException {
		return dao.selectOne(id, pw);
	}
}
