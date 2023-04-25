package com.ssafy.simple.model.dto;

import java.util.ArrayList;
import java.util.List;

public class BoardDto {

	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private String bwriteDate;
	private List<FileDto> files = new ArrayList<FileDto>();

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
	
	

	public List<FileDto> getFiles() {
		return files;
	}

	public void setFiles(List<FileDto> files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bwriter=" + bwriter
				+ ", bwriteDate=" + bwriteDate + ", files=" + files + "]";
	}

	

}
