package model.favorite;

public class FavoriteVO {
	private int fnum;//FNUM INT PRIMARY KEY,   -- 고유 번호	
	private String mid;//MID VARCHAR(100) NOT NULL,
	private String nickname;//NICKNAME VARCHAR(100) NOT NULL,
	private int pnum;//PNUM INT NOT NULL, 
	private String title;//TITLE VARCHAR(300) NOT NULL
	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
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
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "FavoriteVO [fnum=" + fnum + ", mid=" + mid + ", nickname=" + nickname + ", pnum=" + pnum + ", title="
				+ title + "]";
	}


	

}
