package model.postforcafe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pfcafeService")
public class PostForCafeServiceImpl implements PostForCafeService{

	@Autowired
	private PostForCafeDAO pfcafeDAO; 
	
	@Override
	public void insertPost(PostForCafeVO vo) {
		pfcafeDAO.insertPost(vo);
	}
	@Override
	public void insertPostNoTumnail(PostForCafeVO vo) {
		pfcafeDAO.insertPostNoTumnail(vo);
	}
	@Override
	public void updatePost(PostForCafeVO vo) {
		pfcafeDAO.updatePost(vo);
	}
 
	@Override
	public void updateHeart(PostForCafeVO vo) {
		pfcafeDAO.updateHeart(vo);
	}

	@Override
	public void updateCnt(PostForCafeVO vo) {
		pfcafeDAO.updateCnt(vo);
	}
	@Override
	public void updateCnt2(PostForCafeVO vo) {
		pfcafeDAO.updateCnt2(vo);
	}
	@Override
	public void deletePost(PostForCafeVO vo) {
		pfcafeDAO.deletePost(vo);
	}

	@Override
	public PostForCafeVO getPost(PostForCafeVO vo) {
		return pfcafeDAO.getPost(vo);
	}

	@Override
	public List<PostForCafeVO> getPostList(PostForCafeVO vo) {
		return pfcafeDAO.getMyPostList(vo);
	}

	@Override
	public List<PostForCafeVO> getMyPostList(PostForCafeVO vo) {
		return pfcafeDAO.getMyPostList(vo);
	}

	@Override
	public int getPostCnt() {
		return pfcafeDAO.getPostCnt();
	}

	@Override
	public List<PostForCafeVO> getPostListPagenation(int startRow, int endRow) {
		return pfcafeDAO.getPostListPagenation(startRow, endRow);
	}
	@Override
	public List<PostForCafeVO> getPostListTitleSearch(PostForCafeVO vo) {
		return pfcafeDAO.getPostListTitleSearch(vo);
	}
	@Override
	public List<PostForCafeVO> getPostListNickSearch(PostForCafeVO vo) {
		return pfcafeDAO.getPostListNickSearch(vo);
	}
	@Override
	public List<PostForCafeVO> getPostListLocationSearch(PostForCafeVO vo) {
		return pfcafeDAO.getPostListLocationSearch(vo);
	}
	@Override
	public List<PostForCafeVO> searchTitleListPage(PostForCafeVO vo, int startRow, int endRow) {
		return pfcafeDAO.searchTitleListPage(vo, startRow, endRow);
	}
	@Override
	public int searchTitleCnt(PostForCafeVO vo) {
		return pfcafeDAO.searchTitleCnt(vo);
	}
	@Override
	public int searchNickCnt(PostForCafeVO vo) {
		return pfcafeDAO.searchNickCnt(vo);
	}
	@Override
	public int searchLocationCnt(PostForCafeVO vo) {
		return pfcafeDAO.searchLocationCnt(vo);
	}
	@Override
	public List<PostForCafeVO> searchLocationListPage(PostForCafeVO vo, int startRow, int endRow) {
		return pfcafeDAO.searchLocationListPage(vo, startRow, endRow);
	}
	@Override
	public List<PostForCafeVO> searchNinknameListPage(PostForCafeVO vo, int startRow, int endRow) {
		return pfcafeDAO.searchNinknameListPage(vo, startRow, endRow);
	}


}
