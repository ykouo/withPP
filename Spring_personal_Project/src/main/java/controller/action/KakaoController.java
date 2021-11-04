package controller.action;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import model.kakao.KakaoService;
import model.kakao.KakaoVO;
@Controller
public class KakaoController {
	
	@Autowired
	private KakaoService kakaoService;
	
	@RequestMapping(value="/kakaoLogin.do")
	public String kakaoLogin() {
		System.out.println("[kakaoLogin()] ===========================================================");
		StringBuffer loginUrl = new StringBuffer();
		loginUrl.append("https://kauth.kakao.com/oauth/authorize?client_id=");
		loginUrl.append("a6e8ea2eaeba1ab7f3b722a275db29ca"); // kakaoDevelopers의javascript API key
		loginUrl.append("&redirect_uri=");
		loginUrl.append("http://localhost:8088/app/kakaoCallback.do"); // kakaoDevelopers  에 미리 등록해둔 RedirectURI
		loginUrl.append("&response_type=code"); 

		System.out.println("loginUrl: "+loginUrl.toString());
		System.out.println("===========================================================================");
		return "redirect:"+loginUrl.toString(); // kakaoCallback.do로 이동 
	}
	
	@RequestMapping(value="/kakaoCallback.do", method=RequestMethod.GET)
	public String redirectKakao(@RequestParam String code, HttpSession session) throws IOException {
		System.out.println("[redirectKakao()] ===========================================================");		
		// 접속토큰 get
		String kakaoToken=kakaoService.getReturnAccessToken(code);
		System.out.println("kakaoToken: "+  kakaoToken); //✔
		// 정보 get
		Map<String,Object> result=kakaoService.getUserInfo(kakaoToken);
		System.out.println("result: "+result.toString());
		// 정보를 kakaoVO에 세팅
		KakaoVO kakaoVO=new KakaoVO();
		kakaoVO.setNickname((String)result.get("nickname"));
		kakaoVO.setMid((String)result.get("kakaoId"));
		kakaoVO.setBirth((String)result.get("birthday"));
		kakaoVO.setEmail((String)result.get("email"));
		// 확인
		System.out.println("*컨트롤러 출력 : " + kakaoVO);
		
		// kakaoVO를 session에 저장 
		session.setAttribute("kakaoVO", kakaoVO);
		session.setAttribute("kakaoToken", kakaoToken);
		
		System.out.println("===========================================================================");
		return "main.do";
	}
	
	@RequestMapping(value="/kakaoLogout.do")
    public String logout(ModelMap modelMap, HttpSession session)throws IOException {
		System.out.println("[kakaoLogout()] ===========================================================");
		if((String)session.getAttribute("kakaoToken")==null){
        }else {
            kakaoService.getLogout((String)session.getAttribute("kakaoToken"));
        }
        session.invalidate();
		System.out.println("===========================================================================");
        return "main.do";
    }
}