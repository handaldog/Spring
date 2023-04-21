package com.ssafy.product.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssafy.product.model.dao.memberDao;
import com.ssafy.product.model.dto.memberDto;

@Component
public class memberService {

	@Autowired
	private memberDao dao;

	public memberDto login(String userid, String userpw) throws SQLException {
		return dao.selectOne(userid, userpw);

	}

}
