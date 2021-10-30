package model.commforcafe;

public class CommForCafeVO {
	
	// 멤버변수 
	private int cnum;		// 댓글넘버[PK] 	// DB: CNUM INT PRIMARY KEY,
	private int pnum;		// 게시글넘버[NN]	// DB: PNUM INT NOT NULL,
	private String mid; 	// 회원아이디[NN]	// DB: MID VARCHAR(100) NOT NULL,
	private String nickname;// 닉네임[NN]		// DB: NICKNAME VARCHAR(100) NOT NULL,
	private String profileimage;
	private String comm;	// 댓글내용[NN] 	// DB: COMM VARCHAR(1000) NOT NULL,
	private int likecnt;	// 좋아요수[NN]	// DB: LIKECNT INT DEFAULT 0,
	private String cdate;	// 댓글 작성일자[NN]// DB: CDATE DATE DEFAULT SYSDATE NOT NULL,
	
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
