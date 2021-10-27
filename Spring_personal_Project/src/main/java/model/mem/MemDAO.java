package model.mem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

// @Component�� ��ӹ޴� @Repository
@Repository("memDAO")
public class MemDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String insertMemSQL ="INSERT INTO MEM (MID,MPW,MNAME,CALL) VALUES (?,?,?,?)";
	private final String selectAllMemSQL = "SELECT * FROM MEM";
	private final String selectOneMemSQL = "SELECT * FROM MEM WHERE MID=? AND MPW=?";
	private final String updateMemSQL = "UPDATE MEM SET MPW=?,CALL=? WHERE MID=?"; 
	private final String deleteMemSQL =	"DELETE FROM MEM WHERE MID=? AND MPW=?";
	private final String checkMemSQL = "SELECT * FROM MEM WHERE MID=?";
	public boolean insertMem(MemVO vo) {
		System.out.println("dao�� insert");
		//insertMemSQL ="INSERT INTO MEM (MID,MPW,MNAME,CALL,ROLE) VALUES (?,?,?,?,?)";
		boolean res=false;
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(insertMemSQL);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			pstmt.setString(3, vo.getMname());
			pstmt.setString(4, vo.getCall());
			pstmt.executeUpdate();
			res=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return res;
	}
	public void updateMem(MemVO vo) {
		System.out.println("dao�� update");
		//updateMemSQL = "UPDATE MEM SET MPW=?,CALL=? WHERE MID=?"; 
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(updateMemSQL);
			pstmt.setString(1, vo.getMpw());
			pstmt.setString(2, vo.getCall());
			pstmt.setString(3, vo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	public void deleteMem(MemVO vo) {
		System.out.println("dao�� delete");
		//deleteMemSQL ="DELETE FROM MEM WHERE MID=? AND MPW=?";
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(deleteMemSQL);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	public List<MemVO> getMemList(MemVO vo) {
		System.out.println("dao�� getList");
		//  selectAllMemSQL = "SELECT * FROM MEM";
		List<MemVO> datas=new ArrayList<MemVO>();
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(selectAllMemSQL);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemVO data=new MemVO();
				data.setMid(rs.getString("mid"));
				data.setMpw(rs.getString("mpw"));
				data.setMname(rs.getString("mname"));
				data.setCall(rs.getString("call"));
				data.setRole(rs.getString("role"));
				data.setMdate(rs.getDate("mdate"));
				datas.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt,rs);
		}
		return datas;
	}
	public MemVO getMem(MemVO vo) {
		System.out.println("dao�� get");
		// �α��ο� �����Ѵٸ�, MemVO��ü�� ����(��ȯ)
		// �����Ѵٸ� ������ null 
		// selectOneMemSQL = "SELECT * FROM MEM WHERE MID=? AND MPW=?";
		//boolean res=false;
		MemVO data=null;
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(selectOneMemSQL);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new MemVO();
				data.setMid(rs.getString("mid"));
				data.setMpw(rs.getString("mpw"));
				data.setMname(rs.getString("mname"));
				data.setCall(rs.getString("call"));
				data.setRole(rs.getString("role"));
				data.setMdate(rs.getDate("mdate"));
			//res=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt, rs);
		}
		return data;
	}
	public boolean checkMem(MemVO vo) {
		boolean res =false;
		// ȸ�����Խ� ���̵� ������ true ���� ������ false���� 
		MemVO data=null;
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(checkMemSQL);
			pstmt.setString(1, vo.getMid());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new MemVO();
				data.setMid(rs.getString("mid"));
				data.setMpw(rs.getString("mpw"));
				data.setMname(rs.getString("mname"));
				data.setCall(rs.getString("call"));
				data.setRole(rs.getString("role"));
				data.setMdate(rs.getDate("mdate"));
				res=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt, rs);
		}
		return res;
	}
}
