package model.postforcafe;

import java.util.List;

public interface PostForCafeService {
	void insertPost(PostForCafeVO vo);
	void insertPostNoTumnail(PostForCafeVO vo);
	void updatePost(PostForCafeVO vo);
	void updateHeart(PostForCafeVO vo);
	void updateCnt(PostForCafeVO vo);
	void deletePost(PostForCafeVO vo);
	PostForCafeVO getPost(PostForCafeVO vo);
	List<PostForCafeVO> getPostList(PostForCafeVO vo);
	List<PostForCafeVO> getMyPostList(PostForCafeVO vo);
	int getPostCnt();
	List<PostForCafeVO> getPostListPagenation(int startRow, int endRow);
}
 