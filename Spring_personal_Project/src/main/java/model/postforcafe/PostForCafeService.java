package model.postforcafe;

import java.util.List;

public interface PostForCafeService {
	void insertPost(PostForCafeVO vo);
	void insertPostNoTumnail(PostForCafeVO vo);
	void updatePost(PostForCafeVO vo);
	void updateHeart(PostForCafeVO vo);
	void updateCnt(PostForCafeVO vo);
	 void updateCnt2(PostForCafeVO vo);
	void deletePost(PostForCafeVO vo);
	PostForCafeVO getPost(PostForCafeVO vo);
	List<PostForCafeVO> getPostList(PostForCafeVO vo);
	List<PostForCafeVO> getMyPostList(PostForCafeVO vo);
	int getPostCnt();
	List<PostForCafeVO> getPostListPagenation(int startRow, int endRow);
	List<PostForCafeVO> getPostListTitleSearch(PostForCafeVO vo);
	List<PostForCafeVO> getPostListNickSearch(PostForCafeVO vo);
	List<PostForCafeVO> getPostListLocationSearch(PostForCafeVO vo);
	List<PostForCafeVO> searchTitleListPage(PostForCafeVO vo,int startRow, int endRow);
	int searchTitleCnt(PostForCafeVO vo);
	int searchNickCnt(PostForCafeVO vo);
	int searchLocationCnt(PostForCafeVO vo);
	List<PostForCafeVO> searchLocationListPage(PostForCafeVO vo,int startRow, int endRow);
	List<PostForCafeVO> searchNinknameListPage(PostForCafeVO vo,int startRow, int endRow);
}
 