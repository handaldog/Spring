package com.ssafy.product.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssafy.product.model.dao.UserDao;
import com.ssafy.product.model.dto.UserDto;

@Component
public class UserService {
	
	@Autowired
	private UserDao dao;

	public UserDto login(String userid, String userpw) throws SQLException {
		return dao.selectOne(userid, userpw);

	}
}
