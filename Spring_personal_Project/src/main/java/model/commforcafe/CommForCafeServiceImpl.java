package model.commforcafe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.member.MemberVO;
import model.postforcafe.PostForCafeVO;

@Service("cfcafeService")
public class CommForCafeServiceImpl implements CommForCafeService {
	@Autowired
	private CommForCafeDAO cfcafeDAO;
	
	@Override
	public void insertComm(CommForCafeVO vo) {
		System.out.println("insertComm = "+ vo); // ✔
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
	public List<CommForCafeVO> getCommList(PostForCafeVO vo) {
		System.out.println("getCommList"+vo);
		return cfcafeDAO.getCommList(vo);
	}

	@Override
	public int getCommCnt(PostForCafeVO vo) {
		return cfcafeDAO.getCommCnt(vo);
	}
}
