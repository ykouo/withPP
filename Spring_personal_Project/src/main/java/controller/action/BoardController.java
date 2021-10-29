/*package controller.action;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import model.board.BoardDAO;
import model.board.BoardService;
import model.board.BoardVO;
import model.board.Pagenation;

@Controller
@SessionAttributes("data")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@ModelAttribute("sm")
	public Map<String,String> searchMap(){
		Map<String,String> sm=new HashMap<String,String>();
		sm.put("제목", "title");
		sm.put("작성자", "writer");
		return sm;
	}	
	@RequestMapping("/main.do")
	public String main(HttpServletRequest request,@RequestParam(value="condition",defaultValue="title",required=false)String condition,
			@RequestParam(value="keyword",defaultValue="",required=false)String keyword,
			BoardVO bvo,Model model,Pagenation paging){
		
		System.out.println("condition: "+condition+" /keyword : "+keyword);
		int page = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
		int totalCnt = boardService.getBoardCnt();
		System.out.println("page: "+page+" /totalCnt : "+totalCnt);
		paging.setPageNum(page);
		paging.setTotalCount(totalCnt);

		page = ((page-1)*10)+1;
		paging.setPageSize(page+9);

		List<BoardVO> blist = boardService.getBoardList(page, paging.getPageSize());
		System.out.println("blist : " + blist);
		System.out.println("paging : " + paging);
		model.addAttribute("blist", blist);
		model.addAttribute("paging", paging);

		//List<BoardVO> datas = bdao.getBoardList(bvo);
		//model.addAttribute("datas", datas);
		return "index.jsp";
	}
	@RequestMapping("/showBoardList.do")
	public String boardList(HttpServletRequest request,@RequestParam(value="condition",defaultValue="title",required=false)String condition,
			@RequestParam(value="keyword",defaultValue="",required=false)String keyword,
			BoardVO bvo,Model model,Pagenation paging){
		
		System.out.println("condition: "+condition+" /keyword : "+keyword);
		int page = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
		int totalCnt = boardService.getBoardCnt();
		System.out.println("page: "+page+" /totalCnt : "+totalCnt);
		paging.setPageNum(page);
		paging.setTotalCount(totalCnt);

		page = ((page-1)*10)+1;
		paging.setPageSize(page+9);

		List<BoardVO> blist = boardService.getBoardList(page, paging.getPageSize());
		System.out.println("blist : " + blist);
		System.out.println("paging : " + paging);
		model.addAttribute("blist", blist);
		model.addAttribute("paging", paging);

		//List<BoardVO> datas = bdao.getBoardList(bvo);
		//model.addAttribute("datas", datas);
		return "boardList.jsp";
	}
	@RequestMapping("/showpost.do")
	public String showpost(BoardVO bvo,Model model){
		BoardVO data = boardService.getBoard(bvo);
		model.addAttribute("data", data);
		return "boardOne.jsp";
	}	
	@RequestMapping("/newpost.do")
	public String insertBoard(BoardVO bvo) throws IOException {
		MultipartFile fileUpLoad = bvo.getFileUpLoad();
		if (!fileUpLoad.isEmpty()) {
			String fileName = fileUpLoad.getOriginalFilename();
			System.out.println("파일이름 : " + fileName);
			fileUpLoad.transferTo(new File("C:\\Users\\ykouo\\git\\Spring\\Spring_personal_Project\\src\\main\\webapp\\inputFile\\" + fileName));
		}
		boardService.insertBoard(bvo);
		return "showBoardList.do";
	}
	@RequestMapping("/editBoard.do") 
	public String goeditBoard(BoardVO bvo, Model model)  {
		System.out.println("bid="+bvo.getBid()); 
		BoardVO data = boardService.getBoard(bvo);
		model.addAttribute("data", data);

		return "boardEdit.jsp";

		System.out.println("여기 왔어?");
		bvo.setBid(Integer.parseInt(request.getParameter("bid")));
		BoardVO data = bdao.getBoard(bvo);
		model.addAttribute("data", data);
		return "redirect:editBoard.jsp";
	}
	@RequestMapping("/updatepost.do")
	public String updatepost(BoardVO bvo,Model model) {
		boardService.updateBoard(bvo);	// 글 수정용으로 받아온 제목, 내용 업데이트 	
		model.addAttribute("bvo",bvo);
		return "redirect:showpost.do?bid="+bvo.getBid();
	}
	@RequestMapping("/deletepost.do")
	public String deletepost(BoardVO bvo) {		
		boardService.deleteBoard(bvo);
		System.out.println("삭제성공"); 
		return "redirect:main.do";
	}
	@RequestMapping("/searchBoardList.do")
	public String searchBoardList(HttpServletRequest request,@RequestParam(value="condition",defaultValue="title",required=false)String condition,
			@RequestParam(value="keyword",defaultValue="",required=false)String keyword,
			BoardVO bvo,Model model,Pagenation paging){
		if(bvo.getCondition()==null) {
			bvo.setCondition("title");
		}
		if(bvo.getKeyword()==null) {
			bvo.setKeyword("");
		}
		System.out.println("condition: "+condition+" /keyword : "+keyword);
		int page = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
		int totalCnt = boardService.getBoardCnt();
		System.out.println("page: "+page+" /totalCnt : "+totalCnt);
		paging.setPageNum(page);
		paging.setTotalCount(totalCnt);

		page = ((page-1)*10)+1;
		paging.setPageSize(page+9);

		List<BoardVO> blist = boardService.getBoardList(page, paging.getPageSize());
		System.out.println("blist : " + blist);
		System.out.println("paging : " + paging);
		model.addAttribute("blist", blist);
		model.addAttribute("paging", paging);
		model.addAttribute("condition", condition);
		model.addAttribute("keyword", keyword);
		//List<BoardVO> datas = bdao.getBoardList(bvo);
		//model.addAttribute("datas", datas);
		return "boardList.jsp";
	}

}
*/