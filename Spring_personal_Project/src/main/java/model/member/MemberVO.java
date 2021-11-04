package model.member;

import org.springframework.web.multipart.MultipartFile;

public class MemberVO {
	// 유의사항 DATE를 받으면 400Error 발새하므로 DATE컬럼은 String으로 변경해서 받을것 
	
	// 멤버변수 
	private String mid; 	// 회원 아이디[PK]  // DB: MID VARCHAR(100) PRIMARY KEY
	private String mpw; 	// 회원 비밀번호[NN]	// DB: MPW VARCHAR(50) NOT NULL
	private String nickname;// 닉네임[NN] 	// DB: NICKNAME VARCHAR(100) NOT NULL,
	private String phone;	// 휴대폰번호[NN] 	// DB: PHONE VARCHAR(50) NOT NULL,
	private String birth;	// 생일[NN] 		// DB: BIRTH VARCHAR(50) NOT NULL,
	private String postcode;//POSTCODE VARCHAR(100) DEFAULT 'POSTCODE',
	private String roadaddress;//ROADADDRESS VARCHAR(200) DEFAULT 'ROAD ADDRESS',
	private String detailaddress;//DETAILADDRESS VARCHAR(200) DEFAULT 'DETAIL ADDRESS',
	private String email;	// 이메일[NN]		// DB: EMAIL VARCHAR(100) NOT NULL,
	private String role;	// 회원,관리자 구분 	// DB: ROLE VARCHAR(50) DEFAULT 'USER',
	private String accesstoken;// 회원가입 주관	// DB: ACCESS_TOKEN VARCHAR(100) DEFAULT 'withpp',
	private String mdate;	// 회원가입 일시 	// DB: MDATE DATE DEFAULT SYSDATE
	private String profileimage; 
	
	// 파일입출력 변수  
	private MultipartFile fileUpLoad;
	
	
	public MultipartFile getFileUpLoad() {
		return fileUpLoad;
	}
	public void setFileUpLoad(MultipartFile fileUpLoad) {
		this.fileUpLoad = fileUpLoad;
	}
	public String getProfileimage() {
		return profileimage;
	}
	public void setProfileimage(String profileimage) {
		this.profileimage = profileimage;
	}
	// Getter & Setter 
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	} 
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAccesstoken() {
		return accesstoken;
	}
	public void setAccesstoken(String accessToken) {
		this.accesstoken = accessToken;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	
	// toString()
	@Override
	public String toString() {
		return "MemberVO [mid=" + mid + ", mpw=" + mpw + ", nickname=" + nickname + ", phone=" + phone + ", birth="
				+ birth + ", postcode=" + postcode + ", roadaddress=" + roadaddress + ", detailaddress=" + detailaddress
				+ ", email=" + email + ", role=" + role + ", accesstoken=" + accesstoken + ", mdate=" + mdate
				+ ", profileimage=" + profileimage + ", fileUpLoad=" + fileUpLoad + "]";
	}


	 
	
}
