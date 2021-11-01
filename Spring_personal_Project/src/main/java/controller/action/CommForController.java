package controller.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.commforcafe.CommForCafeService;
import model.commforcafe.CommForCafeVO;
import model.postforcafe.PostForCafeVO;

@Controller
public class CommForController {
	@Autowired
	private CommForCafeService cfcafeService;
	
	@RequestMapping("/insertComm.do")
	public String insertComm(CommForCafeVO vo,Model model) {
		cfcafeService.insertComm(vo);
		return "showPost.do";
	} 
	@RequestMapping("/clickLike.do")
	public String updateComm(CommForCafeVO vo,Model model) {
		cfcafeService.updateComm(vo);
		model.addAttribute("vo",vo);
		return "showBoardList.do";
	}
	@RequestMapping("/deleteComm.do")
	public String deleteComm(CommForCafeVO vo,Model model) {
		cfcafeService.deleteComm(vo);
		return "showBoardList.do";
	}
	
	@RequestMapping("/showComm.do")
	public String getCommList(PostForCafeVO vo,Model model) {
		
		return "showBoardList.do";
	}
	
}
