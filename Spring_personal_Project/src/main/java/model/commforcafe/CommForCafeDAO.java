package model.commforcafe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class CommForCafeRowMapper implements RowMapper<CommForCafeVO>{
	@Override
	public CommForCafeVO mapRow(ResultSet rs, int rowNum) throws SQLException {	
		CommForCafeVO vo = new CommForCafeVO();
		vo.setCnum(rs.getInt("cnum"));
		vo.setPnum(rs.getInt("pnum"));
		vo.setMid(rs.getString("mid"));
		vo.setNickname(rs.getString("nickname"));
		vo.setComm(rs.getString("comm"));
		vo.setCdate(rs.getString("cdate"));
		vo.setLikecnt(rs.getInt("likecnt"));	
		return vo;
	}	
}

@Repository
public class CommForCafeDAO {
	// SQL��
	private final String insertCommSQL = "INSERT INTO COMM_FOR_CAFE (CNUM,PNUM,MID,NICKNAME,COMM) VALUES ((SELECT NVL(MAX(CNUM),0)+1 FROM COMM_FOR_CAFE),?,?,?,?);"; 
	private final String updateCommLikeCntSQL = "UPDATE COMM_FOR_CAFE SET LIKECNT=LIKECNT+1 WHERE CNUM=?";
	private final String deleteCommSQL = "DELETE FROM COMM_FOR_CAFE WHERE CNUM=?";
	private final String selectAllCommSQL = "SELECT * FROM COMM_FOR_CAFE WHERE PNUM=? ORDER BY CNUM DESC";
	
	// jdbcTemplate : new �����ڻ���� �����̳ʰ� ���! / <bean> == ��ü�� ���
	// .xml�� �δ㽺���� ������ ���ϱ� ����
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// �޼��� 
	// C ��� �߰�
	public void insertComm(CommForCafeVO vo) {
		Object[] args = {vo.getMid(),vo.getPnum(),vo.getMid(),vo.getNickname(),vo.getComm()};
		jdbcTemplate.update(insertCommSQL,args);	
	}
	// U ��� ���ƿ� ������Ʈ 
	public void updateComm(CommForCafeVO vo) {
		jdbcTemplate.update(updateCommLikeCntSQL,vo.getCnum());
	}
	// D ��� ����
	public void deleteComm(CommForCafeVO vo) {
		jdbcTemplate.update(deleteCommSQL,vo.getCnum());
	}
	
	// R - �Խñ۴� ��� ��� �ҷ����� 
	public List<CommForCafeVO> getCommList(CommForCafeVO vo){	
		Object[] args = {vo.getPnum()};
		return jdbcTemplate.query(selectAllCommSQL, args, new CommForCafeRowMapper());
	}

}
