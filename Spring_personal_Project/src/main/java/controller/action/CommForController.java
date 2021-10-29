package controller.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.commforcafe.CommForCafeService;
import model.commforcafe.CommForCafeVO;

@Controller
public class CommForController {
	@Autowired
	private CommForCafeService cfcafeService;
	
	@RequestMapping("/insertComm.do")
	public String insertComm(CommForCafeVO vo,Model model) {
		cfcafeService.insertComm(vo);
		return "showBoardList.do";
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
	public String getCommList(CommForCafeVO vo,Model model) {
		List<CommForCafeVO> commData = cfcafeService.getCommList(vo);
		model.addAttribute("commData",commData);
		return "showBoardList.do";
	}
	
}
