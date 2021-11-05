package model.postforfood;

import org.springframework.web.multipart.MultipartFile;

public class PostForFoodVO {
	// 멤버변수 
		private int pnum;//PNUM INT PRIMARY KEY,
		private String mid;//MID VARCHAR(100) NOT NULL,
		private String nickname;//NICKNAME VARCHAR(100) NOT NULL,
		private String title;//TITLE VARCHAR(300) NOT NULL,
		private String thumnail;//THUMNAIL VARCHAR(300) DEFAULT '/images/thumnail.png',
		private String content;//CONTENT VARCHAR(1500) NOT NULL,
		private String postcode;//POSTCODE VARCHAR(100) DEFAULT 'POSTCODE',
		private String roadaddress;//ROADADDRESS VARCHAR(200) DEFAULT 'ROAD ADDRESS',
		private String detailaddress;//DETAILADDRESS VARCHAR(200) DEFAULT 'DETAIL ADDRESS',
		private String phone;//LOC_CALL VARCHAR(200) DEFAULT '010-0000-0000',
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

		public String getPostcode() {
			return postcode;
		}
		public void setPostcode(String postcode) {
			this.postcode = postcode;
		}
		public String getRoadaddress() {
			return roadaddress;
		}
		public void setRoadaddress(String roadaddress) {
			this.roadaddress = roadaddress;
		}
		public String getDetailaddress() {
			return detailaddress;
		}
		public void setDetailaddress(String detailaddress) {
			this.detailaddress = detailaddress;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
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
		
		// toString()
		@Override
		public String toString() {
			return "PostForFoodVO [pnum=" + pnum + ", mid=" + mid + ", nickname=" + nickname + ", title=" + title
					+ ", thumnail=" + thumnail + ", content=" + content + ", postcode=" + postcode + ", roadaddress="
					+ roadaddress + ", detailaddress=" + detailaddress + ", phone=" + phone + ", location=" + location
					+ ", cnt=" + cnt + ", heart=" + heart + ", wdate=" + wdate + ", fileUpLoad=" + fileUpLoad
					+ ", condition=" + condition + ", keyword=" + keyword + "]";
		}

		
		

}
