package model.commforfood;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.postforfood.PostForFoodVO;

@Service("cffoodService")
public class CommForFoodServiceImpl implements CommForFoodService {
	@Autowired
	private CommForFoodDAO cffoodDAO;

	@Override
	public void insertComm(CommForFoodVO vo) {
		System.out.println("insertComm = " + vo); // ✔
		cffoodDAO.insertComm(vo);
	}

	@Override
	public void updateComm(CommForFoodVO vo) {
		cffoodDAO.updateComm(vo);
	}

	@Override
	public void deleteComm(CommForFoodVO vo) {
		cffoodDAO.deleteComm(vo);

	}

	@Override
	public int getCommCnt(PostForFoodVO vo) {
		return cffoodDAO.getCommCnt(vo);
	}

	@Override
	public List<CommForFoodVO> getCommList(PostForFoodVO vo) {
		return cffoodDAO.getCommList(vo);
	}

}
