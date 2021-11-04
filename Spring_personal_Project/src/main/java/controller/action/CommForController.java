package controller.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.commforcafe.CommForCafeService;
import model.commforcafe.CommForCafeVO;
import model.postforcafe.PostForCafeService;
import model.postforcafe.PostForCafeVO;

@Controller
public class CommForController {
	@Autowired
	private CommForCafeService cfcafeService;
	@Autowired
	private PostForCafeService pfcafeService;
	
	@RequestMapping("/insertComm.do")
	public String insertComm(CommForCafeVO vo,PostForCafeVO pvo,Model model) {
		cfcafeService.insertComm(vo);
		pfcafeService.updateCnt2(pvo);
		return "showPost.do";
	} 
	@RequestMapping("/clickLike.do")
	public String updateComm(CommForCafeVO vo,PostForCafeVO pvo, Model model) {
		cfcafeService.updateComm(vo);
		model.addAttribute("vo",vo);
		pfcafeService.updateCnt2(pvo);
		return "showPost.do?pnum="+pvo.getPnum();
	}
	@RequestMapping("/deleteComm.do")
	public String deleteComm(CommForCafeVO vo,PostForCafeVO pvo) {
		System.out.println(pvo);
		cfcafeService.deleteComm(vo);
		pfcafeService.updateCnt2(pvo);
		return "showPost.do?pnum="+pvo.getPnum();
	}
	
	@RequestMapping("/showComm.do")
	public String getCommList(PostForCafeVO vo,Model model) {
		
		return "showBoardList.do";
	}
	
}
