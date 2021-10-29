package model.commforcafe;

import java.util.List;

public interface CommForCafeService {
	void insertComm(CommForCafeVO vo);
	void updateComm(CommForCafeVO vo);
	void deleteComm(CommForCafeVO vo);
	List<CommForCafeVO> getCommList(CommForCafeVO vo);
}
