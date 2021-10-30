package model.commforcafe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.member.MemberVO;
import model.postforcafe.PostForCafeVO;

class CommForCafeRowMapper implements RowMapper<CommForCafeVO>{
	@Override
	public CommForCafeVO mapRow(ResultSet rs, int rowNum) throws SQLException {	
		CommForCafeVO vo = new CommForCafeVO();
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
public class CommForCafeDAO {
	// SQL문
	private final String insertCommSQL = "INSERT INTO COMM_FOR_CAFE (CNUM,PNUM,MID,NICKNAME,PROFILEIMAGE,COMM) VALUES ((SELECT NVL(MAX(CNUM),0)+1 FROM COMM_FOR_CAFE),?,?,?,?,?)"; 
	private final String updateCommLikeCntSQL = "UPDATE COMM_FOR_CAFE SET LIKECNT=LIKECNT+1 WHERE CNUM=?";
	private final String deleteCommSQL = "DELETE FROM COMM_FOR_CAFE WHERE CNUM=?";
	private final String selectAllCommSQL = "SELECT * FROM COMM_FOR_CAFE WHERE PNUM=? ORDER BY CNUM DESC";
	private final String getCommCntSQL = "SELECT COUNT(*) FROM COMM_FOR_CAFE WEHRE PNUM=?";
	// jdbcTemplate : new 연산자사용을 컨테이너가 대신! / <bean> == 객체를 등록
	// .xml의 부담스러운 설정을 피하기 위해
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 메서드 
	// C 댓글 추가
	public void insertComm(CommForCafeVO vo) {
		Object[] args = {vo.getPnum(),vo.getMid(),vo.getNickname(),vo.getProfileimage(),vo.getComm()};
		jdbcTemplate.update(insertCommSQL,args);	
	}
	// U 댓글 좋아요 업데이트 
	public void updateComm(CommForCafeVO vo) {
		jdbcTemplate.update(updateCommLikeCntSQL,vo.getCnum());
	}
	// D 댓글 삭제
	public void deleteComm(CommForCafeVO vo) {
		jdbcTemplate.update(deleteCommSQL,vo.getCnum());
	}
	
	// R - 게시글당 댓글 목록 불러오기 
	public List<CommForCafeVO> getCommList(PostForCafeVO vo){	
		Object[] args = {vo.getPnum()};
		return jdbcTemplate.query(selectAllCommSQL, args, new CommForCafeRowMapper());
	}
	// CNT - 댓글 갯수 카운팅 
		public int getCommCnt(PostForCafeVO vo){	
			
			Object[] args = {vo.getPnum()};
			int commCnt = jdbcTemplate.queryForObject(getCommCntSQL, args, Integer.class);
			return commCnt;
		}
	
	
}
