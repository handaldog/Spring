package com.ssafy.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssafy.product.model.dto.memberDto;

@Component
public class memberDao {

	@Autowired
	private DBUtil util;

	public memberDto selectOne(String userid, String userpw) throws SQLException {

		Connection conn = null;
		ResultSet rs = null;
		String sql = null;
		PreparedStatement pst = null;
		memberDto result = new memberDto();

		sql = "select user_id, user_password from members where user_id=? and user_password = ?";
		conn = util.getConnection();
		pst = conn.prepareStatement(sql);

		pst.setString(1, userid);
		pst.setString(2, userpw);

		rs = pst.executeQuery();

		while (rs.next()) {
			result = new memberDto();
			result.setUserid(rs.getString(1));
			result.setUsername(rs.getString(2));

		}

		util.close(rs, pst, conn);
		

		return result;

	}
}
