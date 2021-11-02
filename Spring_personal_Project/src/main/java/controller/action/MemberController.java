package controller.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import model.member.MemberService;
import model.member.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	@ResponseBody
	public String login(HttpServletRequest request, MemberVO vo) throws IOException {
		
		if (vo.getMid() == null || vo.getMid().equals("")) {
			throw new IllegalArgumentException("아이디 미입력 ㅠ");
		}
		MemberVO mem = memberService.getMember(vo);
		if (mem != null) {
			HttpSession session = request.getSession();
			session.setAttribute("mem", mem);
			return "<script>location.href='main.do';</script>";
		} else {
			 return "<script>alert('Login Fail T^T');history.go(-1);</script>";
		}
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index.jsp";
	}

	@RequestMapping("/insertMember.do")
	@ResponseBody
	public String insertMember(HttpServletRequest request, MemberVO vo) throws IllegalStateException, IOException {

		MultipartFile fileUpLoad = vo.getFileUpLoad();
		if (!fileUpLoad.isEmpty()) {
			String filename = fileUpLoad.getOriginalFilename();
			System.out.println("filename=" + filename);
			vo.setProfileimage("image/" + filename);
			fileUpLoad.transferTo(new File(
					"C:\\Users\\ykouo\\git\\withPP\\Spring_personal_Project\\src\\main\\webapp\\image\\" + filename));
			memberService.insertMember(vo);
		} else {
			memberService.insertNoImageMember(vo);
		}

		return "<script>alert('SignUp Complete:D');location.href='login.jsp';</script>";
		
	}

	@RequestMapping("/goMypage.do")
	public String goMypage(MemberVO vo, Model model) {
		MemberVO mem = memberService.getMember(vo);
		System.out.println(mem);
		model.addAttribute("mem", mem);
		return "mypage.jsp";
	}

	@RequestMapping("/updateMember.do")
	public String updateMember(MemberVO vo, Model model) throws IllegalStateException, IOException {
		MultipartFile fileUpLoad = vo.getFileUpLoad();
		if (!fileUpLoad.isEmpty()) {
			String filename = fileUpLoad.getOriginalFilename();
			System.out.println("filename=" + filename);
			vo.setProfileimage("image/" + filename);
			fileUpLoad.transferTo(new File("C:\\Users\\ykouo\\git\\withPP\\Spring_personal_Project\\src\\main\\webapp\\image\\" + filename));
			memberService.updateMember(vo);
		} else {
			vo.setProfileimage("image/thumnail.png");
			memberService.updateMember(vo);
		}
		System.out.println("업데이트 회원정보; " + vo);
		memberService.updateMember(vo);
		return "logout.do";
	}

	@RequestMapping("/deleteMember.do")
	public String deleteMember(MemberVO vo, Model model) {
		System.out.println("업데이트 회원정보; " + vo);
		memberService.deleteMember(vo);
		return "logout.do";
	}
	//아이디 중복체크 
	@RequestMapping("/idCheck.do")
	@ResponseBody
	public String idCheck(MemberVO vo, Model model) {
		 MemberVO mem = memberService.checkMember(vo);
		 String check ="";
		 if(mem != null) {
			 check="no";
		 }else if(mem == null) {
			 check="ok";
		 }
		 return check;
	}
	// 이메일 중복체크 
		@RequestMapping("/emailCheck.do")
		@ResponseBody
		public String emailCheck(MemberVO vo, Model model) {
			 MemberVO mem = memberService.searchMember(vo);
			 String check ="";
			 if(mem != null) {
				 check="no";
			 }else if(mem == null) {
				 check="ok";
			 }
			 return check;
		}
	/*@RequestMapping(value = "/login_kakao.do", method = RequestMethod.GET)
	public String loginKakao(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model)
			throws Exception {
		UrlPathHelper urlPathHelper = new UrlPathHelper();
		String originalURL = urlPathHelper.getOriginatingRequestUri(request);
		Map<String, String[]> paramMap = request.getParameterMap();
		Iterator keyData = paramMap.keySet().iterator();
		CommonData dto = new CommonData();
		while (keyData.hasNext()) {
			String key = ((String) keyData.next());
			String[] value = paramMap.get(key);
			dto.put(key, value[0].toString());
		}
		String url = "https://kauth.kakao.com/oauth/token";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("client_id", "REST 앱키를 입력하세요.");
		String redirect_url = "http://localhost:8080/user/loginpage_kakao_callback";
		map.add("redirect_uri", redirect_url);
		map.add("grant_type", "authorization_code");
		map.add("code", dto.get("code"));
		HttpEntity<LinkedMultiValueMap<String, String>> request2 = new HttpEntity<LinkedMultiValueMap<String, String>>(
				map, headers);
		CommonData response2 = restTemplate.postForObject(url, request2, CommonData.class);
		map.clear();
		model.addAttribute("access_token", response2.get("access_token"));
		return "/user/loginpage_kakao_callback";
	}
*/
}
