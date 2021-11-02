package model.kakao;

public interface KakaoService {
	String getReturnAccessToken(String code); 
	Map<String,Object> getUserInfo(String access_token);
	
	
}
