package model.commforcafe;

import java.util.List;

import model.member.MemberVO;
import model.postforcafe.PostForCafeVO;

public interface CommForCafeService {
	void insertComm(CommForCafeVO vo);
	void updateComm(CommForCafeVO vo);
	void deleteComm(CommForCafeVO vo);
	int getCommCnt(PostForCafeVO vo);
	List<CommForCafeVO> getCommList(PostForCafeVO vo);
}
