package model.member;

public class MemberVO {
	// ���ǻ��� DATE�� ������ 400Error �߻��ϹǷ� DATE�÷��� String���� �����ؼ� ������ 
	
	// ������� 
	private String mid; 	// ȸ�� ���̵�[PK]  // DB: MID VARCHAR(100) PRIMARY KEY
	private String mpw; 	// ȸ�� ��й�ȣ[NN]	// DB: MPW VARCHAR(50) NOT NULL
	private String nickname;// �г���[NN] 	// DB: NICKNAME VARCHAR(100) NOT NULL,
	private String phone;	// �޴�����ȣ[NN] 	// DB: PHONE VARCHAR(50) NOT NULL,
	private String birth;	// ����[NN] 		// DB: BIRTH VARCHAR(50) NOT NULL,
	private String address;	// �ּ�[NN]		// DB: ADDRESS VARCHAR(200) NOT NULL,
	private String email;	// �̸���[NN]		// DB: EMAIL VARCHAR(100) NOT NULL,
	private String role;	// ȸ��,������ ���� 	// DB: ROLE VARCHAR(50) DEFAULT 'USER',
	private String accesstoken;// ȸ������ �ְ�	// DB: ACCESS_TOKEN VARCHAR(100) DEFAULT 'withpp',
	private String mdate;	// ȸ������ �Ͻ� 	// DB: MDATE DATE DEFAULT SYSDATE
		
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
