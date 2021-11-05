package model.postforfood;

import java.util.List;


public interface PostForFoodService {
	void insertPost(PostForFoodVO vo);
	void insertPostNoTumnail(PostForFoodVO vo);
	void updatePost(PostForFoodVO vo);
	void updateHeart(PostForFoodVO vo);
	void updateCnt(PostForFoodVO vo);
	 void updateCnt2(PostForFoodVO vo);
	void deletePost(PostForFoodVO vo);
	PostForFoodVO getPost(PostForFoodVO vo);
	List<PostForFoodVO> getPostList(PostForFoodVO vo);
	List<PostForFoodVO> getMyPostList(PostForFoodVO vo);
	int getPostCnt();
	List<PostForFoodVO> getPostListPagenation(int startRow, int endRow);
	List<PostForFoodVO> getPostListTitleSearch(PostForFoodVO vo);
	List<PostForFoodVO> getPostListNickSearch(PostForFoodVO vo);
	List<PostForFoodVO> getPostListLocationSearch(PostForFoodVO vo);
	
}
