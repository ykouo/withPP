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
			System.out.println("�α��� ����");
			return "redirect:login.jsp"; // redirect: <-- ������ ViewResolver�� ������ �����ϰ� redirect�϶�� �ǹ�
			// �������� View���� �Ǵ°��� �������� url ��û���� 
		}	
	}
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String loginPrint(@ModelAttribute("guest") MemVO mvo) { //@ModelAttribute("guest") �������������� MemVO�� guest��� �θ��� 
		mvo.setMid("Test"); //--> login.jsp���� ��밡�� 
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
		if (!mdao.checkMem(mvo)) { // false == ���̵� ����
			mdao.insertMem(mvo);
			return "redirect:login.jsp";
		} else {
			return "redirect:insertMember.jsp";
		}
	}
}
