package com.ssafy.simple.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.simple.model.dao.MemberDao;
import com.ssafy.simple.model.dto.MemberDto;
import com.ssafy.simple.model.mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	private MemberMapper dao;
	
	public MemberDto login(String id, String pw) throws SQLException {
		return dao.selectOne(id, pw);
	}
}
