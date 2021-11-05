package model.kakao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
@Service("kakaoService")
public class KakaoServiceImpl implements KakaoService{
	@Override
	public String getReturnAccessToken(String code) {
		// 카카오에서 제공하는 access_token 변수
		String access_token = "";
		
		String reqURL = "https://kauth.kakao.com/oauth/token";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			// HttpURLConnection 세팅 
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			
			// buffer 스트림 객체 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=카카오로그인 APIKEY");  // Kakao developer의 javascript api key 카카오로그인 APIKEY
			sb.append("&redirect_uri=http://localhost:8088/app/kakaoCallback.do"); // Kakao developer에 등록해 둔 Redirect URI
			sb.append("&code=" + code);
			
			bw.write(sb.toString());
			bw.flush();
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String br_line = "";
			String result = "";
			while ((br_line = br.readLine()) != null) {
				result += br_line;
			}
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			// 토큰 값 저장 및 리턴
			access_token = element.getAsJsonObject().get("access_token").getAsString();
			//refresh_token = element.getAsJsonObject().get("refresh_token").getAsString();
			br.close();
			bw.close();
			System.out.println("getReturnAccessToken Finish!!!"); // ✔
		} catch (IOException e) {
			e.printStackTrace();
		}
		return access_token;
	}
	@Override
	public Map<String, Object> getUserInfo(String access_token) {
		Map<String,Object> resultMap =new HashMap<String, Object>();
		String reqURL = "https://kapi.kakao.com/v2/user/me";
		try {
			
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			//요청에 필요한 Header에 포함될 내용
			conn.setRequestProperty("Authorization", "Bearer " + access_token);
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			String br_line = "";
			String result = "";
			while ((br_line = br.readLine()) != null) {
				result += br_line;
			}
			System.out.println("response:" + result); // ✔
			
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			
			
			JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
			JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
			
			String nickname = properties.getAsJsonObject().get("nickname").getAsString();
			System.out.println("getUserInfo : " + nickname);
			String kakaoId = kakao_account.getAsJsonObject().get("email").getAsString();
			System.out.println("getUserInfo : " + kakaoId);
			String email = kakao_account.getAsJsonObject().get("email").getAsString();
			System.out.println("getUserInfo : " + email);
			String birthday = kakao_account.getAsJsonObject().get("birthday").getAsString();
			System.out.println("getUserInfo : " + email);
			resultMap.put("nickname", nickname);
			resultMap.put("kakaoId", kakaoId);
			resultMap.put("email", email);
			resultMap.put("birthday", birthday);
			System.out.println("getUserInfo : " + resultMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultMap;
	}
	@Override
	public void getLogout(String access_token) {
		String reqURL ="https://kapi.kakao.com/v1/user/logout";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", "Bearer " + access_token);
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			if(responseCode ==400) throw new RuntimeException("ㅜㅜ카카오 로그아웃 중 발생 ㅜㅜ");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String br_line = "";
			String result = "";
			
			while ((br_line = br.readLine()) != null) {
				result += br_line;
			}
			
			System.out.println("로그아웃 결과 : "+result);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
