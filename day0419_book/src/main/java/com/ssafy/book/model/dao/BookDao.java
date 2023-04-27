package com.ssafy.book.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.book.model.dto.Book;
import com.ssafy.book.model.util.DBUtil;

@Repository
public class BookDao {
	
	// 필드 방식 주입
	@Autowired
	private DBUtil util;
	
	public int insert(Book book) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int result = 0;
		
		try {
			sql = "insert into book_tb (title, writer, price, summary)\r\n" +
					" values\r\n" +
					" (?, ?, ?, ?)";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  book.getTitle());
			pstmt.setString(2,  book.getWriter());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getSummary());
			result = pstmt.executeUpdate();
			
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		return result;
	}
	
	public List<Book> selectAll() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		List<Book> result = new ArrayList<>();
		
		try {
			sql = "select bno, title, writer, price, summary from book_tb";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Book b = new Book();
				b.setBno(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setWriter(rs.getString(3));
				b.setPrice(rs.getInt(4));
				b.setSummary(rs.getString(5));

				result.add(b);
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
			sql = "delete from book_tb where bno=? ";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();
			
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		return result;
	}
	
	public Book select(int bno) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Book result = null;
		
		try {
			sql = "select bno, title, writer, price, summary from book_tb where bno=? ";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = new Book();
				result.setBno(rs.getInt(1));
				result.setTitle(rs.getString(2));
				result.setWriter(rs.getString(3));
				result.setPrice(rs.getInt(4));
				result.setSummary(rs.getString(5));
			}
			
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		return result;
	}
	
	public int update(Book book) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int result = 0;
		
		try {
			sql = "update book_tb \r\n" +
					" set title=?, writer=?, price=?, summary=? " +
					" where bno=?";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  book.getTitle());
			pstmt.setString(2,  book.getWriter());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getSummary());
			pstmt.setInt(5, book.getBno());
			result = pstmt.executeUpdate();
			
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		return result;
	}
	
}
