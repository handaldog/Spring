package com.ssafy.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.ssafy.test.model.dto.AttendanceDto;
import com.ssafy.test.model.dto.UserInfoDto;

@Component
public class AttendanceDao {

	@Autowired
	private DBUtil util;

	public List<AttendanceDto> list() throws SQLException {

		Connection conn = null;
		String sql = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		List<AttendanceDto> result = new ArrayList<AttendanceDto>();

		sql = "select ano, userid, issuedate, issue from attendance";

		conn = util.getConnection();
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();

		while (rs.next()) {
			AttendanceDto attend = new AttendanceDto();
			attend.setAno(rs.getString(1));
			attend.setUserid(rs.getString(2));
			attend.setIssuedate(rs.getString(3));
			attend.setIssue(rs.getString(4));
			result.add(attend);
		}

		util.close(rs, conn, pst);

		return result;
	}

	public int delete(String ano) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int result = 0;

		try {
			sql = "delete from attendance where ano=?";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ano);

			result = pstmt.executeUpdate();
		} finally {
			util.close(rs, pstmt, conn);
		}
		return result;
	}

	public AttendanceDto detail(String ano) throws SQLException { // 조인 시켜서 출력하려 했으나 return 값을 뭐를 넣어야 할지 모르겠음.. attendDto에 더 추가해야하나 생각중...
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		AttendanceDto attendrs = new AttendanceDto();
		UserInfoDto userrs = new UserInfoDto();

		try {
			sql = "select ano, a.userid, name, rclass, rname, issuedate, issue from attendance a inner join userinfo u\r\n on a.userid = u.userid where ano=?";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ano);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				AttendanceDto a = new AttendanceDto();
				UserInfoDto u = new UserInfoDto();
				a.setAno(rs.getString(1));
				a.setUserid(rs.getString(2));
				u.setName(rs.getString(3));
				u.setRclass(rs.getInt(4));
				u.setRname(rs.getString(5));
				a.setIssuedate(rs.getString(6));
				a.setIssue(rs.getString(7));

				attendrs = a;
				userrs = u;
			}

		} finally {
			util.close(rs, pstmt, conn);
		}
		return attendrs;
	}

	public int insert(AttendanceDto attend) throws SQLException {

		Connection conn = null;
		String sql = null;
		PreparedStatement pst = null;
		int result = 0;

		sql = "insert into attendance values(?,?,?,?)";

		conn = util.getConnection();

		pst = conn.prepareStatement(sql);

		pst.setString(1, attend.getAno());
		pst.setString(2, attend.getUserid());
		pst.setString(3, attend.getIssuedate());
		pst.setString(3, attend.getIssue());

		result = pst.executeUpdate();

		util.close(conn, pst);

		return result;
	}

}
