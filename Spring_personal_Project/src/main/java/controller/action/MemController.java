package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.mem.MemDAO;
import model.mem.MemVO;

@Controller
public class MemController {

	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(HttpServletRequest request,MemVO mvo,MemDAO mdao) {
		MemVO data= mdao.getMem(mvo);
		if(data!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("mem", mvo.getMid());
			return "redirect:main.do";	
		}else{
			System.out.println("로그인 실패");
			return "redirect:login.jsp"; // redirect: <-- 기존의 ViewResolver의 설정을 무시하고 redirect하라는 의미
			// 정보없이 View서비스 되는것을 막기위해 url 요청으로 
		}	
	}
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String loginPrint(@ModelAttribute("guest") MemVO mvo) { //@ModelAttribute("guest") 다음페이지에서 MemVO를 guest라고 부를께 
		mvo.setMid("Test"); //--> login.jsp에서 사용가능 
		mvo.setMpw("11");
		return "login.jsp";
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index.jsp";
	}
	@RequestMapping("/joinMember.do")
	public String joinMember(HttpServletRequest request,MemVO mvo,MemDAO mdao){
		if (!mdao.checkMem(mvo)) { // false == 아이디가 없다
			mdao.insertMem(mvo);
			return "redirect:login.jsp";
		} else {
			return "redirect:insertMember.jsp";
		}
	}
}
