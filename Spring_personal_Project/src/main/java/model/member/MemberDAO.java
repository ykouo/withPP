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

	// SQL��
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
	
	// C ȸ������ - Ȩ������ ���Խ� 
	public void insertMember(MemberVO vo) { 
		Object[] args = {vo.getMid(),vo.getMpw(),vo.getNickname(),vo.getPhone(),vo.getBirth(),vo.getAddress(),vo.getEmail(),vo.getProfileimage()};
		jdbcTemplate.update(insertMemberSQL,args);
	}
	// C ȸ������ - Ȩ������ ���Խ� 
	public void insertNoImageMember(MemberVO vo) { 
		Object[] args = {vo.getMid(),vo.getMpw(),vo.getNickname(),vo.getPhone(),vo.getBirth(),vo.getAddress(),vo.getEmail()};
		jdbcTemplate.update(insertMemberSQLNoImage,args);
	} 	
	// C ȸ������ - ������ 
	public void insertAdmin(MemberVO vo) { 
		Object[] args = {vo.getMid(),vo.getMpw(),vo.getNickname(),vo.getPhone(),vo.getBirth(),vo.getAddress(),vo.getEmail()};
		jdbcTemplate.update(insertMemberRoleSQL,args);
	} 
	// U ȸ����������
	public void updateMember(MemberVO vo) {
		Object[] args = {vo.getMpw(),vo.getNickname(),vo.getPhone(),vo.getAddress(),vo.getEmail(),vo.getProfileimage(),vo.getMid()};
		jdbcTemplate.update(updateMemberSQL,args);
	} 
	// D ȸ��Ż��
	public void deleteMember(MemberVO vo) {
		Object[] args = {vo.getMid(),vo.getMpw()};
		jdbcTemplate.update(deleteMemberSQL,args);
	}
	// R - �α���
	public MemberVO getMember(MemberVO vo) { // R - select one // �α��α�� 
		//System.out.println( vo.getMid() + vo.getMpw()+vo.getNickname()+vo.getPhone()+vo.getBirth()+vo.getAddress()+vo.getEmail()+vo.getRole()+vo.getMdate()+vo.getAccesstoken());
		// queryForObject() (queryForMap() �� �ᱹ queryForObject()�� ȣ���ϱ� ������ ������)����ߴµ�, 
		//���� ������� 1 �̾�� �ϴµ� ���� ������� 0 �϶� ������ ���� ������ �߻��Ѵ�
		// try catch ���� ����Ͽ� ó�� 
		try{
			Object[] args= {vo.getMid(),vo.getMpw()};
			return jdbcTemplate.queryForObject(getMemberSQL, args,new MemberRowMapper());
		}catch(Exception e) {
			//e.printStackTrace();
			return null;
		}
	}	 
	// R - ���̵� üũ 
	public MemberVO checkMember(MemberVO vo) { 
		try{
		Object[] args= {vo.getMid()};
			return	jdbcTemplate.queryForObject(checkMemberSQL, args,new MemberRowMapper()); 
		}catch(Exception e) {
			//e.printStackTrace();
			return null;
		}
	}
	// R - ���Ϸ� ���̵�üũ 
	public MemberVO searchMember(MemberVO vo) { // R - select one // �α��α�� 
		System.out.println("����� �Դ�?2 vo : " + vo);
		try{
		Object[] args= {vo.getEmail()};
		return	jdbcTemplate.queryForObject(searchMemberSQL, args,new MemberRowMapper()); 
		}catch(Exception e) {
			//e.printStackTrace();
			return null;
		}
	}	
	// R - ȸ����� �������� 
	public List<MemberVO> getMemberList(MemberVO vo){ // R - select all 1
		return jdbcTemplate.query(getMemberListSQL, new MemberRowMapper());
	} 

	
}
