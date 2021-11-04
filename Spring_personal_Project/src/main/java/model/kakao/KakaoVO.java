package model.kakao;

public class KakaoVO {
	private String mid;
	private String nickname;
	private String profileImage;
	private String email;

	private String birth;
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth= birth;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "KakaoVO [mid=" + mid + ", nickname=" + nickname + ", profileImage=" + profileImage + ", email=" + email
				+ ", birth=" + birth+ "]";
	}
	
	
	
}
