package day_0426_homework.model.dto;

public class BoardDto {
	
	private int bno;
	private String bwriter;
	private String btitle;
	private String bcontent;
	private String bwrite_date;
	
	public BoardDto() {
		super();
	}
	
	public BoardDto(int bno, String bwriter, String btitle, String bcontent, String bwrite_date) {
		super();
		this.bno = bno;
		this.bwriter = bwriter;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwrite_date = bwrite_date;
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
	public String getBwrite_date() {
		return bwrite_date;
	}
	public void setBwrite_date(String bwrite_date) {
		this.bwrite_date = bwrite_date;
	}

	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", bwriter=" + bwriter + ", btitle=" + btitle + ", bcontent=" + bcontent
				+ ", bwrite_date=" + bwrite_date + "]";
	}
	
	

}
