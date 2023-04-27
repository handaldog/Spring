package com.ssafy.board.model.dto;

public class BoardDto {
	private int bno;
	private String bwriter;
	private String btitle;
	private String bcontent;
	private String bwriteDate;

	public BoardDto() {
	}
	
	public BoardDto(int bno, String bwriter, String btitle, String bcontent, String bwriteDate) {
		this.bno = bno;
		this.bwriter = bwriter;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriteDate = bwriteDate;
	}
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBwriteDate() {
		return bwriteDate;
	}
	public void setBwriteDate(String bwriteDate) {
		this.bwriteDate = bwriteDate;
	}

	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", bwriter=" + bwriter + ", btitle=" + btitle + ", bcontent=" + bcontent
				+ ", bwriteDate=" + bwriteDate + "]";
	}
	
}
