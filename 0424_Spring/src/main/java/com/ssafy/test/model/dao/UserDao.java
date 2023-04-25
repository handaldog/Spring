package com.ssafy.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssafy.test.model.dto.UserInfoDto;



@Component
public class UserDao {

	
	@Autowired
	private DBUtil util;

	public UserInfoDto selectOne(String userid, String userpw) throws SQLException {

		Connection conn = null;
		ResultSet rs = null;
		String sql = null;
		PreparedStatement pst = null;
		UserInfoDto result = new UserInfoDto();

		sql = "select userid, position from userinfo where userid=? and userpw = ?";
		conn = util.getConnection();
		pst = conn.prepareStatement(sql);

		System.out.println(userid);
		System.out.println(userpw);
		pst.setString(1, userid);
		pst.setString(2, userpw);

		rs = pst.executeQuery();

		while (rs.next()) {
			result = new UserInfoDto();
			result.setUserid(rs.getString(1));
			result.setPosition(rs.getString(2));

		}

		util.close(rs, pst, conn);

		return result;

	}
}
