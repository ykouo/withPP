package controller.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import model.commforcafe.CommForCafeService;
import model.commforcafe.CommForCafeVO;
import model.postforcafe.Pagenation;
import model.postforcafe.PostForCafeService;
import model.postforcafe.PostForCafeVO;

@Controller
@SessionAttributes("data")
public class PostForCafeController {
	@Autowired
	private PostForCafeService pfcafeService;
	@Autowired
	private CommForCafeService cfcafeService;
	
	@ModelAttribute("sm")
	public Map<String,String> searchMap(){
		Map<String,String> sm=new HashMap<String,String>();
		sm.put("title", "title");
		sm.put("nickname", "nickname");
		sm.put("location", "location");
		return sm;
	}

	
	// 메인 화면으로
	@RequestMapping("/main.do")
	public String main() {

		return "main.jsp";
	}
	// 게시글 리스트  
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
		
		//return "postList.jsp?condition="+vo.getCondition()+"&keyword="+vo.getKeyword();
		return "postList.jsp";
	}
	// 게시글 상세보기 
	@RequestMapping("/showPost.do")
	public String showPost(HttpServletRequest request,PostForCafeVO vo,CommForCafeVO cvo,Model model, Pagenation paging) {
		pfcafeService.updateCnt(vo);
		PostForCafeVO data = pfcafeService.getPost(vo);
		model.addAttribute("data",data);	
		List<CommForCafeVO> commData = cfcafeService.getCommList(vo);
		model.addAttribute("commData",commData);
		
		return "postOne.jsp";
	}
	// 게시글 추가
	@RequestMapping("/insertPost.do")
	public String insertPost(PostForCafeVO vo)throws IllegalStateException, IOException{
	 
		System.out.println("게시글 추가 : " + vo);
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
		//return "showPost.do?pnum="+pnum;
	}
	// 게시글 수정 페이지로 가기 
	@RequestMapping("/goEditPost.do") 
	public String goEditPost(@ModelAttribute("data")PostForCafeVO vo, Model model)  {
		//PostForCafeVO data = pfcafeService.getPost(vo);
		//model.addAttribute("data", data);
		return "postEdit.jsp";
	}
	// 게시글 수정 
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
			pfcafeService.updateCnt2(vo);
		}else {
			System.out.println(vo.getThumnail()); 
			vo.setThumnail(vo.getThumnail()); 
			pfcafeService.updatePost(vo);
			pfcafeService.updateCnt2(vo);
		}
		return "redirect:showPost.do?pnum="+vo.getPnum();
	}
	// 하트 업데이트 
	@RequestMapping("/updateHeart.do")
	public String updateHeart(PostForCafeVO vo, Model model) {
		System.out.println("updateheart: "+vo);
		pfcafeService.updateHeart(vo);
		pfcafeService.updateCnt2(vo);
		return "redirect:showPost.do?pnum="+vo.getPnum();
	}
	// 게시글 삭제 
	@RequestMapping("/deletePost.do")
	public String deletepost(PostForCafeVO vo) {
		pfcafeService.deletePost(vo);
		return "redirect:showPostList.do";
	}
	@RequestMapping("/searchPost.do")
	public String searchPostList(HttpServletRequest request,PostForCafeVO vo,Model model, Pagenation paging) {
		
		System.out.println("여기 왔니?");
		
		System.out.println(vo.getCondition());
		System.out.println(vo.getKeyword());
		
		if(vo.getCondition().equals("title")) {
			//List<PostForCafeVO> searchList = pfcafeService.getPostListTitleSearch(vo);
			int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
			int totalCnt = pfcafeService.searchTitleCnt(vo);
			
			System.out.println("page: " + page + " /totalCnt : " + totalCnt);
			paging.setPageNum(page);
			paging.setTotalCount(totalCnt);
			page = ((page - 1) * 10) + 1;
			paging.setPageSize(page + 9);
			List<PostForCafeVO> searchList = pfcafeService.searchTitleListPage(vo, page, paging.getPageSize());
			System.out.println("paging : " + paging);
			model.addAttribute("paging", paging);	
			String condition=vo.getCondition();
			String keyword=vo.getKeyword();
			model.addAttribute("condition",condition);
			model.addAttribute("keyword",keyword);
			System.out.println("searchList: " + searchList);			
			model.addAttribute("pfcafeList", searchList);
			return "searchPostList.jsp?condition="+vo.getCondition()+"&keyword="+vo.getKeyword();
		}
		else if(vo.getCondition().equals("nickname")) {
			System.out.println("nickname여기 왔니?"); // ✔
			System.out.println("nicknamevo" + vo);
			
			int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
			int totalCnt = pfcafeService.searchNickCnt(vo);
			System.out.println("page: " + page + " /totalCnt : " + totalCnt);
			paging.setPageNum(page);
			paging.setTotalCount(totalCnt);

			page = ((page - 1) * 10) + 1;
			paging.setPageSize(page + 9);
			System.out.println("paging : " + paging);
			List<PostForCafeVO> searchList = pfcafeService.searchNinknameListPage(vo, page, paging.getPageSize());
			model.addAttribute("paging", paging);
			System.out.println("searchList: " + searchList);			
			model.addAttribute("pfcafeList", searchList);
			String condition=vo.getCondition();
			String keyword=vo.getKeyword();
			model.addAttribute("condition",condition);
			model.addAttribute("keyword",keyword);
			System.out.println(vo.getKeyword());
			System.out.println(vo.getCondition());
			return "searchPostList.jsp?condition="+vo.getCondition()+"&keyword="+vo.getKeyword();
		}
		else/*(vo.getCondition().equals("location"))*/ {
			System.out.println("location여기 왔니?");
			
			int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
			int totalCnt = pfcafeService.searchLocationCnt(vo);
			System.out.println("page: " + page + " /totalCnt : " + totalCnt);
			paging.setPageNum(page);
			paging.setTotalCount(totalCnt);
			page = ((page - 1) * 10) + 1;
			paging.setPageSize(page + 9);
			List<PostForCafeVO> searchList = pfcafeService.searchLocationListPage(vo,page, paging.getPageSize());
			System.out.println("paging : " + paging);
			model.addAttribute("paging", paging);
			String condition=vo.getCondition();
			String keyword=vo.getKeyword();
			model.addAttribute("condition",condition);
			model.addAttribute("keyword",keyword);
			System.out.println("searchList: " + searchList);			
			model.addAttribute("pfcafeList", searchList);
			return "searchPostList.jsp?condition="+vo.getCondition()+"&keyword="+vo.getKeyword();
		}
		
	
	}
}
