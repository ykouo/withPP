package model.member;

public class MemberVO {
	// 유의사항 DATE를 받으면 400Error 발새하므로 DATE컬럼은 String으로 변경해서 받을것 
	
	// 멤버변수 
	private String mid; 	// 회원 아이디[PK]  // DB: MID VARCHAR(100) PRIMARY KEY
	private String mpw; 	// 회원 비밀번호[NN]	// DB: MPW VARCHAR(50) NOT NULL
	private String nickname;// 닉네임[NN] 	// DB: NICKNAME VARCHAR(100) NOT NULL,
	private String phone;	// 휴대폰번호[NN] 	// DB: PHONE VARCHAR(50) NOT NULL,
	private String birth;	// 생일[NN] 		// DB: BIRTH VARCHAR(50) NOT NULL,
	private String address;	// 주소[NN]		// DB: ADDRESS VARCHAR(200) NOT NULL,
	private String email;	// 이메일[NN]		// DB: EMAIL VARCHAR(100) NOT NULL,
	private String role;	// 회원,관리자 구분 	// DB: ROLE VARCHAR(50) DEFAULT 'USER',
	private String accesstoken;// 회원가입 주관	// DB: ACCESS_TOKEN VARCHAR(100) DEFAULT 'withpp',
	private String mdate;	// 회원가입 일시 	// DB: MDATE DATE DEFAULT SYSDATE
		
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
				+ birth + ", address=" + address + ", email=" + email + ", role=" + role + ", accesstoken="
				+ accesstoken + ", mdate=" + mdate + "]";
	}
	
	 
	
}
