package controller.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import model.member.MemberService;
import model.member.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	

	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(HttpServletRequest request,MemberVO vo) throws  IOException  {
		
		if(vo.getMid()==null || vo.getMid().equals("")) {
			throw new IllegalArgumentException("아이디 미입력 ㅠ");
		}	
		MemberVO mem= memberService.getMember(vo);
		if(mem!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("mem", mem);
			return "redirect:main.do";	
		}else{
			// 에러 페이지에서 해당 문구를 보여준다.
			throw new EmptyResultDataAccessException("[로그인 Fail] 아이디와 비밀번호를 다시 확인해주세요", 1);
			//return "redirect:login.jsp";
		}
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index.jsp";
	}
	@RequestMapping("/insertMember.do")
	public String insertMember(HttpServletRequest request,MemberVO vo) throws IllegalStateException, IOException{
		
		MultipartFile fileUpLoad = vo.getFileUpLoad();
		if(!fileUpLoad.isEmpty()) {
			String filename = fileUpLoad.getOriginalFilename();
			System.out.println("filename="+filename);
			vo.setProfileimage("image/"+filename);
			fileUpLoad.transferTo(new File("C:\\Users\\ykouo\\git\\withPP\\Spring_personal_Project\\src\\main\\webapp\\image\\"+filename));
			memberService.insertMember(vo);
		}else {
			memberService.insertNoImageMember(vo);
		} 
		
		return "redirect:login.jsp";
		/*	System.out.println(memberService.checkMember(vo));
		if (!memberService.checkMember(vo)) { // false == 아이디가 없다
			memberService.insertMember(vo);
			return "redirect:login.jsp";
		} else {
			return "redirect:signIn.jsp";
		}*/
	}
	@RequestMapping("/goMypage.do")
	public String goMypage(MemberVO vo, Model model){
		MemberVO mem = memberService.getMember(vo);
		System.out.println(mem);
		model.addAttribute("mem", mem);
		return "mypage.jsp";
	}
	@RequestMapping("/updateMember.do")
	public String updateMember(MemberVO vo, Model model){
		System.out.println("업데이트 회원정보; " + vo);
		memberService.updateMember(vo);
		return "logout.do";
	}
	@RequestMapping("/deleteMember.do")
	public String deleteMember(MemberVO vo, Model model){
		System.out.println("업데이트 회원정보; " + vo);
		memberService.deleteMember(vo);
		return "logout.do";
	}
}
