package model.board;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	//멤버변수 
	private int bid; //BID INT PRIMARY KEY,
	private String mid; //MID VARCHAR(50) NOT NULL,
	private String title; //TITLE VARCHAR(50) NOT NULL,
	private String content; //CONTENT VARCHAR(100) NOT NULL,
	private String wdate; //WDATE DATE DEFAULT SYSDATE
	
	// 파일입출력 
	private MultipartFile fileUpLoad; 
	
	// 검색용 변수 
	private String condition;
	private String keyword;
	
	// Getter & Setter
	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public MultipartFile getFileUpLoad() {
		return fileUpLoad;
	}
	public void setFileUpLoad(MultipartFile fileUpLoad) {
		this.fileUpLoad = fileUpLoad;
	}
	// toString 
	@Override
	public String toString() {
		return "BoardVO [bid=" + bid + ", mid=" + mid + ", title=" + title + ", content=" + content + ", wdate=" + wdate + "]";
	}	
}