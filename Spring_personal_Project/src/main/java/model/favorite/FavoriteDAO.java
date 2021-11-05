package model.favorite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.member.MemberVO;
import model.postforcafe.PostForCafeVO;
import oracle.jdbc.proxy.annotation.Post;



class FavoriteRowMapper implements RowMapper<FavoriteVO> {
	@Override
	public FavoriteVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		FavoriteVO vo = new FavoriteVO();
		vo.setFnum(rs.getInt("fnum"));
		vo.setPnum(rs.getInt("pnum"));
		vo.setMid(rs.getString("mid"));
		vo.setNickname(rs.getString("nickname"));
		vo.setTitle(rs.getString("title"));
		return vo;
	}
}

@Repository
public class FavoriteDAO {
	// SQL문
	private final String insertFavoriteSQL="INSERT INTO FAVORITE (FNUM,MID,NICKNAME,PNUM,TITLE) VALUES ((SELECT NVL(MAX(FNUM),0)+1 FROM FAVORITE),?,?,?,?)"; 
	private final String deleteFavoriteSQL="DELETE FROM FAVORITE WHERE FNUM=? AND MID=?";
	private final String getFavoriteListSQL="SELECT * FROM FAVORITE WHERE MID=? ORDER BY FNUM DESC";
	private final String getFavoriteSQL="SELECT * FROM FAVORITE WHERE PNUM=? AND MID=?";
	private final String getFavCntSQL = "SELECT COUNT(*) FROM FAVORITE WHERE MID=?";

	// jdbcTemplate 추가
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 메서드
		public void insertFavorite(PostForCafeVO vo) {
			System.out.println("Favorite DAO 출력 : insertPost " + vo);
			Object[] args = {vo.getMid(), vo.getNickname(),vo.getPnum() ,vo.getTitle()};
			jdbcTemplate.update(insertFavoriteSQL, args);
		}

		public void deleteFavorite(FavoriteVO vo) {
			System.err.println("Favorite DAO 출력 : insertPost ");
			System.out.println("Favorite DAO 출력 : insertPost " + vo);
			Object[] args = { vo.getFnum(),vo.getMid()};
			jdbcTemplate.update(deleteFavoriteSQL, args);
		}
		public List<FavoriteVO> getFavoriteList(MemberVO vo) {
			System.out.println("Favorite DAO 출력 : getFavoriteList");
			System.out.println(vo);
			Object[] args = { vo.getMid() };
			return jdbcTemplate.query(getFavoriteListSQL, args, new FavoriteRowMapper());
		}
		public FavoriteVO getFavorite(PostForCafeVO vo,MemberVO mvo) {
			System.out.println("Favorite DAO 출력 : getFavoriteList");
			System.out.println(vo);
			try {
				Object[] args = { vo.getPnum(),mvo.getMid()};
				return jdbcTemplate.queryForObject(getFavoriteSQL, args, new FavoriteRowMapper());
			}catch(Exception e){
				return null;
			}
		}
		public int getFavCnt(MemberVO mvo) {
			Object[] args = {mvo.getMid()};
			int total = jdbcTemplate.queryForObject(getFavCntSQL,args,Integer.class);
			System.out.println("getFavCnt=" + total);
			return total;
		}
}
