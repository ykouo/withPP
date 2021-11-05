package model.favorite;

import java.util.List;

import model.member.MemberVO;
import model.postforcafe.PostForCafeVO;

public interface FavoriteService {
	void insertFavorite(PostForCafeVO vo);
	void deleteFavorite(FavoriteVO vo);
	List<FavoriteVO> getFavoriteList(MemberVO vo);
	FavoriteVO getFavorite(PostForCafeVO vo,MemberVO mvo);
	int getFavCnt(MemberVO mvo);
}
