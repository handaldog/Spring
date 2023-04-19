package com.ssafy.book.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ssafy.book.model.dto.bookdto;

@Service // @repository, @component
public class bookdao {

	@Autowired
	private DBUtil util;

	public int insert(bookdto book) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int result = 0;

		try {
			sql = "insert into book_tb (title, writer, price, summary)\r\n" + " values\r\n" + " (?, ?, ?, ?)";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getWriter());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getSummary());
			result = pstmt.executeUpdate();
		} finally {
			util.close(rs, pstmt, conn);
		}
		return result;
	}

	public List<bookdto> selectAll() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		List<bookdto> result = new ArrayList<>();

		try {
			sql = "select bno, title, writer, price, summary from book_tb";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bookdto b = new bookdto();
				b.setBno(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setWriter(rs.getString(3));
				b.setPrice(rs.getInt(4));
				b.setSummary(rs.getString(5));

				result.add(b); // 리스트에 담기 까먹지 않게 주의
			}
		} finally {
			util.close(rs, pstmt, conn);
		}
		return result;
	}

	public int delete(int bno) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int result = 0;

		try {
			sql = "delete from book_tb where bno=?";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);

			result = pstmt.executeUpdate();
		} finally {
			util.close(rs, pstmt, conn);
		}
		return result;
	}

	public bookdto detail(int bno) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		bookdto result = new bookdto();

		try {
			sql = "select bno, title, writer, price, summary from book_tb where bno=?";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				bookdto b = new bookdto();
				b.setBno(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setWriter(rs.getString(3));
				b.setPrice(rs.getInt(4));
				b.setSummary(rs.getString(5));

				result = b;
			}

		} finally {
			util.close(rs, pstmt, conn);
		}
		return result;
	}
}
