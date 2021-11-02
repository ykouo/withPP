package model.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class MemberRowMapper implements RowMapper<MemberVO>{
	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {	
		MemberVO vo = new MemberVO();
		vo.setMid(rs.getString("mid"));
		vo.setMpw(rs.getString("mpw"));
		vo.setNickname(rs.getString("nickname"));
		vo.setPhone(rs.getString("phone"));
		vo.setBirth(rs.getString("birth"));
		vo.setAddress(rs.getString("address"));
		vo.setEmail(rs.getString("email"));
		vo.setRole(rs.getString("role"));
		vo.setAccesstoken(rs.getString("accesstoken"));
		vo.setMdate(rs.getString("mdate"));
		vo.setProfileimage(rs.getString("profileimage"));
		System.out.println(vo);
		return vo;
		
	}	
}
@Repository 
public class MemberDAO {

	// SQL문
	private final String insertMemberSQL="INSERT INTO MEMBER (MID,MPW,NICKNAME,PHONE,BIRTH,ADDRESS,EMAIL,PROFILEIMAGE) VALUES (?,?,?,?,?,?,?,?)";
	private final String insertMemberSQLNoImage="INSERT INTO MEMBER (MID,MPW,NICKNAME,PHONE,BIRTH,ADDRESS,EMAIL,PROFILEIMAGE) VALUES (?,?,?,?,?,?,?,'images/thumnail.png')";

	private final String insertMemberRoleSQL="INSERT INTO MEMBER (MID,MPW,NICKNAME,PHONE,BIRTH,ADDRESS,EMAIL,ROLE) VALUES (?,?,?,?,?,?,?,'ADMIN')";
	private final String updateMemberSQL="UPDATE MEMBER SET MPW=?,NICKNAME=?,PHONE=?,ADDRESS=?,EMAIL=?,PROFILEIMAGE=? WHERE MID=?";
	private final String deleteMemberSQL="DELETE FROM MEMBER WHERE MID=? AND MPW=?";
	private final String getMemberSQL="SELECT * FROM MEMBER WHERE MID=? AND MPW=?";
	private final String checkMemberSQL="SELECT * FROM MEMBER WHERE MID=?";
	private final String getMemberListSQL="SELECT * FROM MEMBER ORDER BY MDATE DESC";
	private final String searchMemberSQL="SELECT * FROM MEMBER WHERE EMAIL=?";
	private final String checkIdSQL="SELECT COUNT(MID) FROM MEMBER WHERE MID=?";
	
	
	// JDBCTemplete
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// C 회원가입 - 홈페이지 가입시 
	public void insertMember(MemberVO vo) { 
		Object[] args = {vo.getMid(),vo.getMpw(),vo.getNickname(),vo.getPhone(),vo.getBirth(),vo.getAddress(),vo.getEmail(),vo.getProfileimage()};
		jdbcTemplate.update(insertMemberSQL,args);
	}
	// C 회원가입 - 홈페이지 가입시 
	public void insertNoImageMember(MemberVO vo) { 
		Object[] args = {vo.getMid(),vo.getMpw(),vo.getNickname(),vo.getPhone(),vo.getBirth(),vo.getAddress(),vo.getEmail()};
		jdbcTemplate.update(insertMemberSQLNoImage,args);
	} 	
	// C 회원가입 - 관리자 
	public void insertAdmin(MemberVO vo) { 
		Object[] args = {vo.getMid(),vo.getMpw(),vo.getNickname(),vo.getPhone(),vo.getBirth(),vo.getAddress(),vo.getEmail()};
		jdbcTemplate.update(insertMemberRoleSQL,args);
	} 
	// U 회원정보변경
	public void updateMember(MemberVO vo) {
		Object[] args = {vo.getMpw(),vo.getNickname(),vo.getPhone(),vo.getAddress(),vo.getEmail(),vo.getProfileimage(),vo.getMid()};
		jdbcTemplate.update(updateMemberSQL,args);
	} 
	// D 회원탈퇴
	public void deleteMember(MemberVO vo) {
		Object[] args = {vo.getMid(),vo.getMpw()};
		jdbcTemplate.update(deleteMemberSQL,args);
	}
	// R - 로그인
	public MemberVO getMember(MemberVO vo) { // R - select one // 로그인기능 
		//System.out.println( vo.getMid() + vo.getMpw()+vo.getNickname()+vo.getPhone()+vo.getBirth()+vo.getAddress()+vo.getEmail()+vo.getRole()+vo.getMdate()+vo.getAccesstoken());
		// queryForObject() (queryForMap() 도 결국 queryForObject()를 호출하기 때문에 동일함)사용했는데, 
		//쿼리 결과값이 1 이어야 하는데 실제 결과값은 0 일때 다음과 같은 에러가 발생한다
		// try catch 문을 사용하여 처리 
		try{
			Object[] args= {vo.getMid(),vo.getMpw()};
			return jdbcTemplate.queryForObject(getMemberSQL, args,new MemberRowMapper());
		}catch(Exception e) {
			//e.printStackTrace();
			return null;
		}
	}	 
	// R - 아이디 체크 
	public MemberVO checkMember(MemberVO vo) { 
		try{
		Object[] args= {vo.getMid()};
			return	jdbcTemplate.queryForObject(checkMemberSQL, args,new MemberRowMapper()); 
		}catch(Exception e) {
			//e.printStackTrace();
			return null;
		}
	}
	// R - 메일로 아이디체크 
	public MemberVO searchMember(MemberVO vo) { // R - select one // 로그인기능 
		System.out.println("여기는 왔니?2 vo : " + vo);
		try{
		Object[] args= {vo.getEmail()};
		return	jdbcTemplate.queryForObject(searchMemberSQL, args,new MemberRowMapper()); 
		}catch(Exception e) {
			//e.printStackTrace();
			return null;
		}
	}	
	// R - 회원목록 가져오기 
	public List<MemberVO> getMemberList(MemberVO vo){ // R - select all 1
		return jdbcTemplate.query(getMemberListSQL, new MemberRowMapper());
	} 

	
}
