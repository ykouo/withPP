package model.naver;

public class NaverVO {
	// ������� 
	private String mid; 	// ȸ�� ���̵�[PK]  // DB: MID VARCHAR(100) PRIMARY KEY
	private String nickname;// �г���[NN] 	// DB: NICKNAME VARCHAR(100) NOT NULL,
	private String phone;	// �޴�����ȣ[NN] 	// DB: PHONE VARCHAR(50) NOT NULL,
	private String birth;	// ����[NN] 		// DB: BIRTH VARCHAR(50) NOT NULL,
	private String email;	// �̸���[NN]		// DB: EMAIL VARCHAR(100) NOT NULL,
	private String mdate;	// ȸ������ �Ͻ� 	// DB: MDATE DATE DEFAULT SYSDATE
	private String profileimage;
	
	// Getter & Setter 
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	public String getProfileimage() {
		return profileimage;
	}
	public void setProfileimage(String profileimage) {
		this.profileimage = profileimage;
	}
	
	// toString
	@Override
	public String toString() {
		return "NaverVO [mid=" + mid + ", nickname=" + nickname + ", phone=" + phone + ", birth=" + birth + ", email="
				+ email + ", mdate=" + mdate + ", profileimage=" + profileimage + "]";
	} 

	
	
}
