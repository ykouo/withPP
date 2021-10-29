package controller.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import model.postforcafe.Pagenation;
import model.postforcafe.PostForCafeService;
import model.postforcafe.PostForCafeVO;

@Controller
@SessionAttributes("data")
public class PostForCafeController {
	@Autowired
	private PostForCafeService pfcafeService;
	// ���� ȭ������
	@RequestMapping("/main.do")
	public String main() {

		return "main.jsp";
	}
	// �Խñ� ����Ʈ  
	@RequestMapping("/showPostList.do")
	public String postList(HttpServletRequest request,PostForCafeVO vo,Model model, Pagenation paging) {

		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		int totalCnt = pfcafeService.getPostCnt();
		System.out.println("page: " + page + " /totalCnt : " + totalCnt);
		paging.setPageNum(page);
		paging.setTotalCount(totalCnt);

		page = ((page - 1) * 10) + 1;
		paging.setPageSize(page + 9);

		List<PostForCafeVO> pfcafeList = pfcafeService.getPostListPagenation(page, paging.getPageSize());
		System.out.println("pfcafeList: " + pfcafeList);
		System.out.println("paging : " + paging);
		model.addAttribute("pfcafeList", pfcafeList);
		model.addAttribute("paging", paging);

		return "postList.jsp";
	}
	// �Խñ� �󼼺��� 
	@RequestMapping("/showPost.do")
	public String showPost(HttpServletRequest request,PostForCafeVO vo,Model model, Pagenation paging) {
		pfcafeService.updateCnt(vo);
		PostForCafeVO data = pfcafeService.getPost(vo);
		model.addAttribute("data",data);	
		return "postOne.jsp";
	}
	// �Խñ� �߰�
	@RequestMapping("/insertPost.do")
	public String insertPost(PostForCafeVO vo)throws IllegalStateException, IOException{
	 
		System.out.println("�Խñ� �߰� : " + vo);
		MultipartFile fileUpLoad = vo.getFileUpLoad();
		if(!fileUpLoad.isEmpty()) {
			String filename = fileUpLoad.getOriginalFilename();
			System.out.println("filename="+filename);
			vo.setThumnail("image/"+filename);
			fileUpLoad.transferTo(new File("C:\\Users\\ykouo\\git\\withPP\\Spring_personal_Project\\src\\main\\webapp\\image\\"+filename));
			pfcafeService.insertPost(vo);
		}else {
			pfcafeService.insertPostNoTumnail(vo);
		} 
		
		return "redirect:showPostList.do";
		//return "showPost.do?pnum="+vo.getPnum();
	}
	// �Խñ� ���� �������� ���� 
	@RequestMapping("/goEditPost.do") 
	public String goEditPost(@ModelAttribute("data")PostForCafeVO vo, Model model)  {
		//PostForCafeVO data = pfcafeService.getPost(vo);
		//model.addAttribute("data", data);
		return "postEdit.jsp";
	}
	// �Խñ� ���� 
	@RequestMapping("/updatePost.do")
	public String updatepost(PostForCafeVO vo, Model model)throws IllegalStateException, IOException {
		System.out.println("updatePost: "+vo);	
		MultipartFile fileUpLoad = vo.getFileUpLoad();
		if(!fileUpLoad.isEmpty()) {
			String filename = fileUpLoad.getOriginalFilename();
			System.out.println("filename="+filename);
			vo.setThumnail("image/"+filename);
			fileUpLoad.transferTo(new File("C:\\Users\\ykouo\\git\\withPP\\Spring_personal_Project\\src\\main\\webapp\\image\\"+filename));
			pfcafeService.updatePost(vo);
		}
		
		return "redirect:showPost.do?pnum="+vo.getPnum();
	}
	// ��Ʈ ������Ʈ 
	@RequestMapping("/updateHeart.do")
	public String updateHeart(PostForCafeVO vo, Model model) {
		System.out.println("updateheart: "+vo);
		pfcafeService.updateHeart(vo);	
		return "redirect:showPost.do?pnum="+vo.getPnum();
	}
	// �Խñ� ���� 
	@RequestMapping("/deletePost.do")
	public String deletepost(PostForCafeVO vo) {
		pfcafeService.deletePost(vo);
		return "redirect:showPostList.do";
	}
}
