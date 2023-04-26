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

@Repository
public class BoardDao {

	@Autowired
	private DBUtil util;
	
	public int insert(BoardDto board) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			String sql = "insert into board_tb(bwriter, btitle, bcontent, bwrite_date) \n" +
						" values (?, ?, ?, now()) ";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBwriter());
			pstmt.setString(2, board.getBtitle());
			pstmt.setString(3, board.getBcontent());
			
			result = pstmt.executeUpdate();
			
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		return result;
	}
	
	public int delete(int bno) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			String sql = "delete from board_tb where bno = ? ";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);

			result = pstmt.executeUpdate();
			
		
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		return result;
	}
	
	public List<BoardDto> selectAll() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardDto> result = new ArrayList<>();
		
		try {
			String sql = "select bno, bwriter, btitle, bcontent, bwrite_date \n"+
						" from board_tb";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardDto board = new BoardDto();
				board.setBno(rs.getInt(1));
				board.setBwriter(rs.getString(2));
				board.setBtitle(rs.getString(3));
				board.setBcontent(rs.getString(4));
				board.setBwriteDate(rs.getString(5));
				
				result.add(board);
			}
		
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		return result;
	}
	
	public BoardDto selectOne(int bno) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDto result = null;
		
		try {
			String sql = "select bno, bwriter, btitle, bcontent, bwrite_date \n"+
						" from board_tb where bno = ?";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = new BoardDto();
				result.setBno(rs.getInt(1));
				result.setBwriter(rs.getString(2));
				result.setBtitle(rs.getString(3));
				result.setBcontent(rs.getString(4));
				result.setBwriteDate(rs.getString(5));
			}
		
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		return result;
	}
	
}
