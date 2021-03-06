package controller.action;

import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.mail.MailVO;
import model.member.MemberService;
import model.member.MemberVO;

@Controller

public class MailController {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private MemberService memberService;

	@RequestMapping("/mail.do") 
	@ResponseBody
	public String sendMail(MailVO vo) { 
		System.out.println("메일보내기 vo :" + vo);
		try { 
			String from = vo.getFrom();
			String subject = vo.getSubject();
			String to = vo.getTo();
			String content = vo.getContent();

			MimeMessage message = mailSender.createMimeMessage(); 
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8"); 
			messageHelper.setTo(to); 
			String htmlStr = "<h4>답변받을 메일주소 :"+from+"</h4><hr><h3><b>문의내용</b></h3><br><p>"+content+"</p>";
			messageHelper.setText(htmlStr,true); // html 코드를 읽을수 있도록하는 설정 
			messageHelper.setFrom(from); 
			messageHelper.setSubject(subject); 
		
			mailSender.send(message); 
		}catch(Exception e){ 
			System.out.println(e); 
		} 
		System.out.println("문의메일보내기 성공!");
		return "<script>alert('MailSuccess:D');location.href='contact.jsp';</script>"; 
	}
	
	@RequestMapping("/tempPw.do") 
	@ResponseBody
	public String sendTempPw(MailVO vo, MemberVO mvo) { 
		try { 		
			mvo.setEmail(vo.getTo());
			System.out.println("이거 확인:" + mvo);
			if(memberService.checkMember(mvo)==null) {
				System.out.println("메일발송실패");		
				return "<script>alert('WithPP hava no Id T^T You search first ID');history.go(-1);</script>";
			}else{			
			String from = "anykouo@gmail.com";
			String subject = "["+mvo.getMid()+"]님의 임시비밀번호";
			String to = vo.getTo();
			String content = RandomStringUtils.randomAlphanumeric(10);
			
			MimeMessage message = mailSender.createMimeMessage(); 
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8"); 
			messageHelper.setTo(to); 
			String htmlStr = "<hr><h3><b>임시비밀번호 : </b></h3><br><p>"+content+"</p>";
			messageHelper.setText(htmlStr,true); // html 코드를 읽을수 있도록하는 설정 
			messageHelper.setFrom(from); 
			messageHelper.setSubject(subject); 
			System.out.println("임시비밀번호보내기 vo :" + vo);
			mailSender.send(message);
			mvo.setMpw(content);
			mvo.setEmail(to);
			System.out.println("메일발송 mvo: "+ mvo);
			memberService.updatePwMember(mvo);
			System.out.println("메일발송 완료");				
			}
		}catch(Exception e){ 
			System.out.println(e); 		
		}
		return "<script>alert('MailSuccess:D');location.href='login.jsp';</script>";
	}
	@RequestMapping("/searchID.do") 
	@ResponseBody
	public String sendID(MailVO vo, MemberVO mvo) { 
		System.out.println("아이디찾기vo :" + vo);
		System.out.println(mvo);
		try { 		
			if(memberService.searchMember(mvo)==null) {
				System.out.println("메일발송실패");		
				return "<script>alert('There is no registration history.');location.href='searchIdPw.jsp';</script>";
			}else{			
			mvo = memberService.searchMember(mvo);
			System.out.println("아이디확인 : " + mvo.getMid());
			String from = "anykouo@gmail.com";
			String subject = "아이디 찾기 결과입니다";
			String to = mvo.getEmail();
			String content = "가입하셨던 아이디는["+mvo.getMid()+"] 입니다.";

			MimeMessage message = mailSender.createMimeMessage(); 
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8"); 
			messageHelper.setTo(to); 
			String htmlStr = "<hr><h3><b>"+content+"</b></h3>";
			messageHelper.setText(htmlStr,true); // html 코드를 읽을수 있도록하는 설정 
			messageHelper.setFrom(from); 
			messageHelper.setSubject(subject); 
			mailSender.send(message);
			System.out.println("메일발송 완료");				
			}
		}catch(Exception e){ 
			//System.out.println(e); 		
		}
		return "<script>alert('MailSuccess:D');location.href='searchIdPw.jsp';</script>";
	}	
	
	
}