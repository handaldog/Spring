package com.ssafy.book.mode.dto;

public class BookDto {

	private int bno;
	private String title;
	private String writer;
	private int price;
	private String summary;

	public BookDto() {
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSummary() {
		return summary;
	}

	@Override
	public String toString() {
		return "Book [bno=" + bno + ", title=" + title + ", writer=" + writer + ", price=" + price + ", summary="
				+ summary + "]";
	}

	public BookDto(int bno, String title, String writer, int price, String summary) {
		super();
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.price = price;
		this.summary = summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
}