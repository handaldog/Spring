package com.ssafy.simple.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.simple.model.dao.MemberMapper;
import com.ssafy.simple.model.dto.MemberDto;

@Service // @Component
public class MemberService {
	
	@Autowired
	private MemberMapper mm;

	public MemberDto login(String id, String pw) throws SQLException {
		System.out.println("mapper??"+mm);
		return mm.selectOne(id, pw);
	}
}
