package com.ssafy.simple.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.simple.model.dto.MemberDto;

@Repository
public class MemberDao {
	@Autowired
	private DBUtil util;

	public MemberDto selectOne(String id, String pw) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		MemberDto result = null;

		try {
			sql = "select user_id, user_name from member_tb where user_id=? and user_pw=?";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new MemberDto();
				result.setUserId(rs.getString(1));
				result.setUserName(rs.getString(2));
			}
		} finally {
			util.close(rs, pstmt, conn);
		}

		return result;
	}

//	Connection conn = null;
//	PreparedStatement pstmt = null;
//	String sql = null;
//	ResultSet rs = null;
//	MemberDTO result = null;
//	
//	try {
//		
//	}finally {
//		util.close(rs, pstmt, conn);
//	}
//	
//	return result;
}
