package model.favorite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.member.MemberVO;
import model.postforcafe.PostForCafeVO;

@Service("favoriteService")
public class FavoriteServiceImpl implements FavoriteService{
	
	@Autowired
	private FavoriteDAO favoriteDAO;
	
	@Override
	public void insertFavorite(PostForCafeVO vo) {
		favoriteDAO.insertFavorite(vo);
	}

	@Override
	public void deleteFavorite(FavoriteVO vo) {
		favoriteDAO.deleteFavorite(vo);
	}

	@Override
	public List<FavoriteVO> getFavoriteList(MemberVO vo) {
		return favoriteDAO.getFavoriteList(vo);
	}

	@Override
	public FavoriteVO getFavorite(PostForCafeVO vo,MemberVO mvo) {		
		return favoriteDAO.getFavorite(vo,mvo);
	}

	@Override
	public int getFavCnt(MemberVO mvo) {
		return favoriteDAO.getFavCnt(mvo);
	}

}
