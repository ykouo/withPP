package model.postforfood;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pffoodService")
public class PostForFoodServiceImpl implements PostForFoodService{

	@Autowired
	private PostForFoodDAO pffoodDAO; 
	
	@Override
	public void insertPost(PostForFoodVO vo) {
		pffoodDAO.insertPost(vo);
	}
	@Override
	public void insertPostNoTumnail(PostForFoodVO vo) {
		pffoodDAO.insertPostNoTumnail(vo);
	}
	@Override
	public void updatePost(PostForFoodVO vo) {
		pffoodDAO.updatePost(vo);
	}
 
	@Override
	public void updateHeart(PostForFoodVO vo) {
		pffoodDAO.updateHeart(vo);
	}

	@Override
	public void updateCnt(PostForFoodVO vo) {
		pffoodDAO.updateCnt(vo);
	}
	@Override
	public void updateCnt2(PostForFoodVO vo) {
		pffoodDAO.updateCnt2(vo);
	}
	@Override
	public void deletePost(PostForFoodVO vo) {
		pffoodDAO.deletePost(vo);
	}

	@Override
	public PostForFoodVO getPost(PostForFoodVO vo) {
		return pffoodDAO.getPost(vo);
	}

	@Override
	public List<PostForFoodVO> getPostList(PostForFoodVO vo) {
		return pffoodDAO.getMyPostList(vo);
	}

	@Override
	public List<PostForFoodVO> getMyPostList(PostForFoodVO vo) {
		return pffoodDAO.getMyPostList(vo);
	}

	@Override
	public int getPostCnt() {
		return pffoodDAO.getPostCnt();
	}

	@Override
	public List<PostForFoodVO> getPostListPagenation(int startRow, int endRow) {
		return pffoodDAO.getPostListPagenation(startRow, endRow);
	}
	@Override
	public List<PostForFoodVO> getPostListTitleSearch(PostForFoodVO vo) {
		return pffoodDAO.getPostListTitleSearch(vo);
	}
	@Override
	public List<PostForFoodVO> getPostListNickSearch(PostForFoodVO vo) {
		return pffoodDAO.getPostListNickSearch(vo);
	}
	@Override
	public List<PostForFoodVO> getPostListLocationSearch(PostForFoodVO vo) {
		return pffoodDAO.getPostListLocationSearch(vo);
	}

}
