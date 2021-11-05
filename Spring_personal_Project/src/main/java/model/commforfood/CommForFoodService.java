package model.commforfood;

import java.util.List;

import model.postforfood.PostForFoodVO;

public interface CommForFoodService {
	void insertComm(CommForFoodVO vo);
	void updateComm(CommForFoodVO vo);
	void deleteComm(CommForFoodVO vo);
	int getCommCnt(PostForFoodVO vo);
	List<CommForFoodVO> getCommList(PostForFoodVO vo);
}
