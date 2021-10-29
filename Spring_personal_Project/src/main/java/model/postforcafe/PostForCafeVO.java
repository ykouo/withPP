package model.postforcafe;

import org.springframework.web.multipart.MultipartFile;

public class PostForCafeVO {
	
	// 멤버변수 
	private int pnum;//PNUM INT PRIMARY KEY,
	private String mid;//MID VARCHAR(100) NOT NULL,
	private String nickname;//NICKNAME VARCHAR(100) NOT NULL,
	private String title;//TITLE VARCHAR(300) NOT NULL,
	private String thumnail;//THUMNAIL VARCHAR(300) DEFAULT '/images/thumnail.png',
	private String content;//CONTENT VARCHAR(1500) NOT NULL,
	private String locaddress;//LOC_ADDRESS VARCHAR(200) NOT NULL,
	private String loccall;//LOC_CALL VARCHAR(200) DEFAULT '010-0000-0000',
	private String location;//LOCATION VARCHAR(100) DEFAULT '지역미입력',
	private int cnt;//CNT INT DEFAULT 0 NOT NULL,
	private String heart;//HEART VARCHAR(50) DEFAULT 'N',
	private String wdate;//WDATE DATE DEFAULT SYSDATE NOT NULL
	
	// 파일입출력 변수  
	private MultipartFile fileUpLoad;
	
	// 검색용 변수 
	private String condition;
	private String keyword;
	
	// Getter & Setter
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumnail() {
		return thumnail;
	}
	public void setThumnail(String thumnail) {
		this.thumnail = thumnail;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLocaddress() {
		return locaddress;
	}
	public void setLocaddress(String locaddress) {
		this.locaddress = locaddress;
	}
	public String getLoccall() {
		return loccall;
	}
	public void setLoccall(String loccall) {
		this.loccall = loccall;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getHeart() {
		return heart;
	}
	public void setHeart(String heart) {
		this.heart = heart;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	// 파일입출력 Getter & Setter
	public MultipartFile getFileUpLoad() {
		return fileUpLoad;
	}
	public void setFileUpLoad(MultipartFile fileUpLoad) {
		this.fileUpLoad = fileUpLoad;
	}
	// 검색용 Getter & Setter
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
	@Override
	public String toString() {
		return "PostForCafeVO [pnum=" + pnum + ", mid=" + mid + ", nickname=" + nickname + ", title=" + title
				+ ", thumnail=" + thumnail + ", content=" + content + ", locaddress=" + locaddress + ", loccall="
				+ loccall + ", location=" + location + ", cnt=" + cnt + ", heart=" + heart + ", wdate=" + wdate
				+ ", fileUpLoad=" + fileUpLoad + ", condition=" + condition + ", keyword=" + keyword + "]";
	}
	
	// toString()
	
}
