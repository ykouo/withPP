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
		System.out.println("���Ϻ����� vo :" + vo);
		try { 
			String from = vo.getFrom();
			String subject = vo.getSubject();
			String to = vo.getTo();
			String content = vo.getContent();

			MimeMessage message = mailSender.createMimeMessage(); 
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8"); 
			messageHelper.setTo(to); 
			String htmlStr = "<h4>�亯���� �����ּ� :"+from+"</h4><hr><h3><b>���ǳ���</b></h3><br><p>"+content+"</p>";
			messageHelper.setText(htmlStr,true); // html �ڵ带 ������ �ֵ����ϴ� ���� 
			messageHelper.setFrom(from); 
			messageHelper.setSubject(subject); 
		
			mailSender.send(message); 
		}catch(Exception e){ 
			System.out.println(e); 
		} 
		System.out.println("���Ǹ��Ϻ����� ����!");
		return "<script>alert('MailSuccess:D');location.href='contact.jsp';</script>"; 
	}
	
	@RequestMapping("/tempPw.do") 
	@ResponseBody
	public String sendTempPw(MailVO vo, MemberVO mvo) { 
		System.out.println("�ӽú�й�ȣ������ vo :" + vo);
		System.out.println(mvo);
		try { 		
			if(memberService.checkMember(mvo)==null) {
				System.out.println("���Ϲ߼۽���");		
			}else{			
			String from = "anykouo@gmail.com";
			String subject = "["+mvo.getMid()+"]���� �ӽú�й�ȣ";
			String to = vo.getTo();
			String content = RandomStringUtils.randomAlphanumeric(10);

			MimeMessage message = mailSender.createMimeMessage(); 
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8"); 
			messageHelper.setTo(to); 
			String htmlStr = "<hr><h3><b>�ӽú�й�ȣ : </b></h3><br><p>"+content+"</p>";
			messageHelper.setText(htmlStr,true); // html �ڵ带 ������ �ֵ����ϴ� ���� 
			messageHelper.setFrom(from); 
			messageHelper.setSubject(subject); 
			mailSender.send(message);
			System.out.println("���Ϲ߼� �Ϸ�");		
			//res = "<script>alert('MailSuccess:D');location.href='login.jsp';</script>";
			}
		}catch(Exception e){ 
			System.out.println(e); 
			return "<script>alert('WithPP hava no Id T^T You search first ID');history.go(-1);</script>";
		}
		return "<script>alert('MailSuccess:D');location.href='login.jsp';</script>";
	}	
}