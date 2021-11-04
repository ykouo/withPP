package controller.action;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import model.naver.NaverService;
import model.naver.NaverVO;
@Controller
public class NaverController {
	@Autowired
	private NaverService naverService;
	
	@RequestMapping("/naverLogin.do")
	public String naverLogin(HttpSession session) {
		StringBuffer loginUrl=new StringBuffer();
		SecureRandom random=new SecureRandom();
		String state=new BigInteger(130, random).toString();
		loginUrl.append("https://nid.naver.com/oauth2.0/authorize?&client_id=");
		loginUrl.append("lp8E1RwMgk1P2n3A28zk");
		loginUrl.append("&redirect_uri=");
		loginUrl.append("http://localhost:8088/app/naverCallback.do");
		loginUrl.append("&state="+state);
		loginUrl.append("&response_type=code");

		return "redirect:"+loginUrl.toString();
	}
	
	@RequestMapping(value="/naverCallback.do", method=RequestMethod.GET)
	public String redirectNaver(@RequestParam String code,@RequestParam String state, HttpSession session) {
		System.out.println("##########"+code+"##########");
		
		String naverToken=naverService.getReturnAccessToken(code, state);
		
		Map<String,Object> result=naverService.getUserInfo(naverToken);
		System.out.println("resutl: "+result.toString());
		System.out.println("컨트롤러 출력: "+result.get("nickname")+"/"+result.get("name")+"/"+result.get("email")+"/"+result.get("gender")+"/"+result.get("age")+"/"+result.get("mobile"));
		NaverVO naverVO=new NaverVO();
		
		naverVO.setEmail((String)result.get("email"));
		naverVO.setPhone((String)result.get("mobile"));
		naverVO.setNickname((String)result.get("name"));
		naverVO.setMid((String)result.get("nickname"));
		
		session.setAttribute("naverVO", naverVO);
		session.setAttribute("naverToken", naverToken);
		System.out.println("check");
		
		return "main.do";
	}
	
	@RequestMapping("/naverLogout.do")
	public String naverLogout(HttpSession session) {
		if((String)session.getAttribute("naverToken")==null) {
		}
		else {
			naverService.getLogout((String)session.getAttribute("naverToken"));
		}
		session.invalidate();
		return "main.do";
	}
}