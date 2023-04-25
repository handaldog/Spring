package com.ssafy.test.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssafy.test.model.dao.UserDao;
import com.ssafy.test.model.dto.UserInfoDto;



@Component
public class UserService {

	@Autowired
	private UserDao dao;

	public UserInfoDto login(String userid, String userpw) throws SQLException {
		//System.out.println(dao.selectOne(userid, userpw).toString());
		return dao.selectOne(userid, userpw);

	}
}
