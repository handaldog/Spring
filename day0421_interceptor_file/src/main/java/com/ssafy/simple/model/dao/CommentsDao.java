package com.ssafy.simple.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.simple.model.dto.CommentsDto;

@Repository
public class CommentsDao {
	@Autowired
	private DBUtil util;
	
	public int insert(CommentsDto comment) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			String sql = "insert into comment_tb(bno, user_id, content) \n" +
						" values (?, ?, ?) ";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comment.getBno());
			pstmt.setString(2, comment.getUserId());
			pstmt.setString(3, comment.getContent());
			
			result = pstmt.executeUpdate();
			
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		return result;
	}
	
	public List<CommentsDto> selectAll(int bno) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CommentsDto> result = new ArrayList<>();
		
		try {
			String sql = "select comment_id, bno, user_id, content from comment_tb where bno = ? ";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				CommentsDto comment = new CommentsDto();
				comment.setCommentId(rs.getInt(1));
				comment.setBno(rs.getInt(2));
				comment.setUserId(rs.getString(3));
				comment.setContent(rs.getString(4));
				
				result.add(comment);
			}
		
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		return result;
	}
	
}
