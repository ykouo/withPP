package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.favorite.FavoriteService;
import model.favorite.FavoriteVO;
import model.member.MemberVO;
import model.postforcafe.Pagenation;
import model.postforcafe.PostForCafeVO;


@Controller
@SessionAttributes("Fdata")
public class FavoriteController {

	@Autowired
	private FavoriteService favoriteService;


	@RequestMapping("/showFavoriteList.do")
	public String showFavoriteList(HttpServletRequest request,MemberVO vo, Model model,
			Pagenation paging) {

		List<FavoriteVO> Fdata = favoriteService.getFavoriteList(vo);
		model.addAttribute("Fdata", Fdata);
		System.out.println(Fdata);
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		int totalCnt = favoriteService.getFavCnt(vo);
		System.out.println("page: " + page + " /totalCnt : " + totalCnt);
		paging.setPageNum(page);
		paging.setTotalCount(totalCnt);
		page = ((page - 1) * 10) + 1;
		paging.setPageSize(page + 9);
		System.out.println("paging : " + paging);
		model.addAttribute("paging", paging);	
		return "favorite.jsp";
	}

	// 게시글 추가
	@RequestMapping("/insertFav.do")
	@ResponseBody
	public String insertFav(PostForCafeVO vo,MemberVO mvo)  {
		System.out.println("insertFav.do1  :" + vo + " / mvo:" +mvo);
		System.out.println("insertFav.do2  : " + favoriteService.getFavorite(vo,mvo));
	
		if(favoriteService.getFavorite(vo,mvo) == null) {	// 만약 관심글에 등록되어있자 않다면
			favoriteService.insertFavorite(vo);
			return "<script>alert('Complete Add Favorite Post');history.go(-1);</script>";
		}else {
			return "<script>alert('already Favorite Post');history.go(-1);</script>";
		}
		
	}

	// 게시글 추가
	@RequestMapping("/deleteFav.do")
	public String deleteFav(FavoriteVO vo)  {

		System.out.println("관심글 추가 : " + vo);
		favoriteService.deleteFavorite(vo);
	
		return "mypage.jsp";
	}


}
