package model.commforfood;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.postforfood.PostForFoodVO;

class CommForFoodRowMapper implements RowMapper<CommForFoodVO>{
	@Override
	public CommForFoodVO mapRow(ResultSet rs, int rowNum) throws SQLException {	
		CommForFoodVO vo = new CommForFoodVO();
		vo.setCnum(rs.getInt("cnum"));
		vo.setPnum(rs.getInt("pnum"));
		vo.setMid(rs.getString("mid"));
		vo.setNickname(rs.getString("nickname"));
		vo.setProfileimage(rs.getString("profileimage"));
		vo.setComm(rs.getString("comm"));
		vo.setCdate(rs.getString("cdate"));
		vo.setLikecnt(rs.getInt("likecnt"));	
		return vo;
	}	
}

@Repository
public class CommForFoodDAO {

	// SQL문
	private final String insertCommSQL = "INSERT INTO COMM_FOR_FOOD (CNUM,PNUM,MID,NICKNAME,PROFILEIMAGE,COMM) VALUES ((SELECT NVL(MAX(CNUM),0)+1 FROM COMM_FOR_FOOD),?,?,?,?,?)"; 
	private final String updateCommLikeCntSQL = "UPDATE COMM_FOR_FOOD SET LIKECNT=LIKECNT+1 WHERE CNUM=?";
	private final String deleteCommSQL = "DELETE FROM COMM_FOR_FOOD WHERE CNUM=?";
	private final String selectAllCommSQL = "SELECT * FROM COMM_FOR_FOOD WHERE PNUM=? ORDER BY CNUM DESC";
	private final String getCommCntSQL = "SELECT COUNT(*) FROM COMM_FOR_FOOD WEHRE PNUM=?";
	// jdbcTemplate : new 연산자사용을 컨테이너가 대신! / <bean> == 객체를 등록
	// .xml의 부담스러운 설정을 피하기 위해
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 메서드 
	// C 댓글 추가
	public void insertComm(CommForFoodVO vo) {
		Object[] args = {vo.getPnum(),vo.getMid(),vo.getNickname(),vo.getProfileimage(),vo.getComm()};
		jdbcTemplate.update(insertCommSQL,args);	
	}
	// U 댓글 좋아요 업데이트 
	public void updateComm(CommForFoodVO vo) {
		jdbcTemplate.update(updateCommLikeCntSQL,vo.getCnum());
	}
	// D 댓글 삭제
	public void deleteComm(CommForFoodVO vo) {
		jdbcTemplate.update(deleteCommSQL,vo.getCnum());
	}
	
	// R - 게시글당 댓글 목록 불러오기 
	public List<CommForFoodVO> getCommList(PostForFoodVO vo){	
		Object[] args = {vo.getPnum()};
		return jdbcTemplate.query(selectAllCommSQL, args, new CommForFoodRowMapper());
	}
	// CNT - 댓글 갯수 카운팅 
		public int getCommCnt(PostForFoodVO vo){	
			
			Object[] args = {vo.getPnum()};
			int commCnt = jdbcTemplate.queryForObject(getCommCntSQL, args, Integer.class);
			return commCnt;
		}
	
	
}
