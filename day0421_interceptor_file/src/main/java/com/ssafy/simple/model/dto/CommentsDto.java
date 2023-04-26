package com.ssafy.simple.model.dto;

public class CommentsDto {
	
	private int commentId;
	private int bno;
	private String userId;
	private String content;
	
	public CommentsDto() {
		super();
	}


	public CommentsDto(int commentId, int bno, String userId, String content) {
		super();
		this.commentId = commentId;
		this.bno = bno;
		this.userId = userId;
		this.content = content;
	}


	public int getCommentId() {
		return commentId;
	}


	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}


	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "CommentsDto [commentId=" + commentId + ", bno=" + bno + ", userId=" + userId + ", content=" + content
				+ "]";
	}
	
}
