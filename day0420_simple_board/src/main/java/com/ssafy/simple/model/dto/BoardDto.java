package com.ssafy.simple.model.dto;

public class BoardDto {

	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private String bwriteDate;

	public BoardDto() {
		super();
	}

	public BoardDto(int bno, String btitle, String bcontent, String bwriter) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriter = bwriter;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
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

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public String getBwriteDate() {
		return bwriteDate;
	}

	public void setBwriteDate(String bwriteDate) {
		this.bwriteDate = bwriteDate;
	}

	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bwriter=" + bwriter
				+ ", bwriteDate=" + bwriteDate + "]";
	}

}
