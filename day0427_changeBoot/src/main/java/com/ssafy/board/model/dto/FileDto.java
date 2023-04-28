package com.ssafy.board.model.dto;

public class FileDto {

	private int fno;
	private int bno;
	private String original_name;
	private String saved_path;
	
	

	public FileDto() {
		super();
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getOriginal_name() {
		return original_name;
	}

	public void setOriginal_name(String original_name) {
		this.original_name = original_name;
	}

	public String getSaved_path() {
		return saved_path;
	}

	public void setSaved_path(String saved_path) {
		this.saved_path = saved_path;
	}

	@Override
	public String toString() {
		return "FileDto [fno=" + fno + ", bno=" + bno + ", original_name=" + original_name + ", saved_path="
				+ saved_path + "]";
	}

}
