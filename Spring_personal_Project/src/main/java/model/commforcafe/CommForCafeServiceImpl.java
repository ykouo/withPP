package model.commforcafe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cfcafeService")
public class CommForCafeServiceImpl implements CommForCafeService {
	@Autowired
	private CommForCafeDAO cfcafeDAO;
	
	@Override
	public void insertComm(CommForCafeVO vo) {
		cfcafeDAO.insertComm(vo);
	}

	@Override
	public void updateComm(CommForCafeVO vo) {
		cfcafeDAO.updateComm(vo);
	}

	@Override
	public void deleteComm(CommForCafeVO vo) {
		cfcafeDAO.deleteComm(vo);
	}

	@Override
	public List<CommForCafeVO> getCommList(CommForCafeVO vo) {
		return cfcafeDAO.getCommList(vo);
	}

}
