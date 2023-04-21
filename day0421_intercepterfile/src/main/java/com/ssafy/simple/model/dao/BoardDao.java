package com.ssafy.simple.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.simple.model.dto.BoardDto;



@Repository // @Component
public class BoardDao {
	@Autowired
	private DBUtil util;
//////////////////////////////////////////////////////////////////////////////	
	public int insert(BoardDto board) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			sql = " insert into board_tb (bwriter, btitle, bcontent, bwrite_date)\r\n" + 
					" values(?, ?, ?, now())";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getBwriter());
			pstmt.setString(2, board.getBtitle());
			pstmt.setString(3, board.getBcontent());
			
			result = pstmt.executeUpdate();
		}finally {
			util.close(rs, pstmt, conn);
		}
		
		return result;
	}
	
	public int delete(int bno) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			sql = " delete from board_tb where bno=? ";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		}finally {
			util.close(rs, pstmt, conn);
		}
		
		return result;
	}
	
	public List<BoardDto> selectAll() throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		List<BoardDto> result = new ArrayList<BoardDto>();
		
		try {
			sql = "select bno, bwriter, btitle, bwrite_date from board_tb";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDto b = new BoardDto();
				b.setBno(rs.getInt(1));
				b.setBwriter(rs.getString(2));
				b.setBtitle(rs.getString(3));
				b.setBwriteDate(rs.getString(4));
				result.add(b);
			}
		}finally {
			util.close(rs, pstmt, conn);
		}
		
		return result;
	}
	
	public BoardDto selectOne(int bno) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		BoardDto result = null;
		
		try {
			sql = "select bno, bwriter, btitle, bwrite_date, bcontent from board_tb where=?";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				BoardDto b = new BoardDto();
				b.setBno(rs.getInt(1));
				b.setBwriter(rs.getString(2));
				b.setBtitle(rs.getString(3));
				b.setBwriteDate(rs.getString(4));
				b.setBcontent(rs.getString(5));
				result = b;
			}
		}finally {
			util.close(rs, pstmt, conn);
		}
		
		return result;
	}
	
}
