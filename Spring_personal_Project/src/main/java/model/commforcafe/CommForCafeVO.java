package model.commforcafe;

public class CommForCafeVO {
	
	// ������� 
	private int cnum;		// ��۳ѹ�[PK] 	// DB: CNUM INT PRIMARY KEY,
	private int pnum;		// �Խñ۳ѹ�[NN]	// DB: PNUM INT NOT NULL,
	private String mid; 	// ȸ�����̵�[NN]	// DB: MID VARCHAR(100) NOT NULL,
	private String nickname;// �г���[NN]		// DB: NICKNAME VARCHAR(100) NOT NULL,
	private String profileimage;
	private String comm;	// ��۳���[NN] 	// DB: COMM VARCHAR(1000) NOT NULL,
	private int likecnt;	// ���ƿ��[NN]	// DB: LIKECNT INT DEFAULT 0,
	private String cdate;	// ��� �ۼ�����[NN]// DB: CDATE DATE DEFAULT SYSDATE NOT NULL,
	
	// Getter & Setter
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
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
	public String getComm() {
		return comm;
	}
	public void setComm(String comm) {
		this.comm = comm;
	}
	public int getLikecnt() {
		return likecnt;
	}
	public void setLikecnt(int likecnt) {
		this.likecnt = likecnt;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	
	public String getProfileimage() {
		return profileimage;
	}
	public void setProfileimage(String profileimage) {
		this.profileimage = profileimage;
	}
	@Override
	public String toString() {
		return "CommForCafeVO [cnum=" + cnum + ", pnum=" + pnum + ", mid=" + mid + ", nickname=" + nickname
				+ ", profileimage=" + profileimage + ", comm=" + comm + ", likecnt=" + likecnt + ", cdate=" + cdate
				+ "]";
	}

}
