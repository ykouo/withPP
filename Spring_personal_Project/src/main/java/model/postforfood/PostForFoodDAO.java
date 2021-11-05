package model.postforfood;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PostForFoodDAO {


class PostForFoodRowMapper implements RowMapper<PostForFoodVO> {
	@Override
	public PostForFoodVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PostForFoodVO vo = new PostForFoodVO();
		vo.setPnum(rs.getInt("pnum"));
		vo.setMid(rs.getString("mid"));
		vo.setNickname(rs.getString("nickname"));
		vo.setTitle(rs.getString("title"));
		vo.setThumnail(rs.getString("thumnail"));
		vo.setContent(rs.getString("content"));
		vo.setPostcode(rs.getString("postcode"));
		vo.setRoadaddress(rs.getString("roadaddress"));
		vo.setDetailaddress(rs.getString("detailaddress"));
		vo.setPhone(rs.getString("phone"));
		vo.setLocation(rs.getString("location"));
		vo.setCnt(rs.getInt("cnt"));
		vo.setHeart(rs.getString("heart"));
		vo.setWdate(rs.getString("wdate"));
		return vo;
	}
}



	// SQL��
	private final String insertPostSQL = "INSERT INTO POST_FOR_FOOD (PNUM,MID,NICKNAME,TITLE,THUMNAIL,CONTENT,POSTCODE,ROADADDRESS,DETAILADDRESS,PHONE,LOCATION) VALUES ((SELECT NVL(MAX(PNUM),0)+1 FROM POST_FOR_FOOD),?,?,?,?,?,?,?,?,?,?)";
	private final String insertPostSQLNothumnail = "INSERT INTO POST_FOR_Food (PNUM,MID,NICKNAME,TITLE,THUMNAIL,CONTENT,POSTCODE,ROADADDRESS,DETAILADDRESS,PHONE,LOCATION) VALUES ((SELECT NVL(MAX(PNUM),0)+1 FROM POST_FOR_FOOD),?,?,?,'images/thumnail.png',?,?,?,?,?,?)";
	private final String updatePostSQL = "UPDATE POST_FOR_FOOD SET NICKNAME=?,TITLE=?,THUMNAIL=?,CONTENT=?,POSTCODE=?,ROADADDRESS=?,DETAILADDRESS=?,PHONE=?,LOCATION=? WHERE PNUM=?";
	private final String updatePostSQL_Heart = "UPDATE POST_FOR_FOOD SET HEART=? WHERE PNUM=?";
	private final String updatePostSQL_Cnt = "UPDATE POST_FOR_FOOD SET CNT=CNT+1 WHERE PNUM=?";
	private final String updatePostSQL_Cnt2 = "UPDATE POST_FOR_FOOD SET CNT=CNT-1 WHERE PNUM=?";
	private final String deletePostSQL = "DELETE FROM POST_FOR_FOOD WHERE PNUM=?";
	private final String getPostSQL = "SELECT * FROM POST_FOR_FOOD WHERE PNUM=?";
	private final String getPostListSQL = "SELECT * FROM POST_FOR_FOOD ORDER BY PNUM DESC";
	private final String getMyPostListSQL = "SELECT * FROM POST_FOR_FOOD WHERE MID=? ORDER BY PNUM DESC";
	private final String getPostCntSQL = "SELECT COUNT(*) FROM POST_FOR_FOOD";
	private final String searchPostSQL_Title = "SELECT * FROM POST_FOR_FOOD WHERE TITLE LIKE '%'||?||'%' ORDER BY PNUM DESC";
	private final String searchPostSQL_Nickname = "SELECT * FROM POST_FOR_FOOD WHERE LOCATION LIKE '%'||?||'%' ORDER BY PNUM DESC";
	private final String searchPostSQL_Location = "SELECT * FROM POST_FOR_FOOD WHERE NICKNAME LIKE '%'||?||'%' ORDER BY PNUM DESC";

	// jdbcTemplate �߰�
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// �޼���
	// C �Խñ� �߰�
	public void insertPost(PostForFoodVO vo) {
		System.out.println("PostForFood DAO ��� : insertPost " + vo);
		Object[] args = { vo.getMid(), vo.getNickname(), vo.getTitle(), vo.getThumnail(), vo.getContent(),
				vo.getPostcode(), vo.getRoadaddress(), vo.getDetailaddress(), vo.getPhone(), vo.getLocation() };
		jdbcTemplate.update(insertPostSQL, args);
	}

	public void insertPostNoTumnail(PostForFoodVO vo) {
		System.err.println("PostForFood DAO ��� : insertPost ");
		System.out.println("PostForFood DAO ��� : insertPost " + vo);
		Object[] args = { vo.getMid(), vo.getNickname(), vo.getTitle(), vo.getContent(), vo.getPostcode(),
				vo.getRoadaddress(), vo.getDetailaddress(), vo.getPhone(), vo.getLocation() };
		jdbcTemplate.update(insertPostSQLNothumnail, args);
	}

	// U �Խñ� ����
	public void updatePost(PostForFoodVO vo) {
		System.out.println("PostForFood DAO ��� : updatePost");
		Object[] args = { vo.getNickname(), vo.getTitle(), vo.getThumnail(), vo.getContent(), vo.getPostcode(),
				vo.getRoadaddress(), vo.getDetailaddress(), vo.getPhone(), vo.getLocation(), vo.getPnum() };
		jdbcTemplate.update(updatePostSQL, args);
	}

	public void updateHeart(PostForFoodVO vo) {
		System.out.println("PostForFood DAO ��� : updateHeart");
		Object[] args = { vo.getHeart(), vo.getPnum() };
		jdbcTemplate.update(updatePostSQL_Heart, args);
	}

	public void updateCnt(PostForFoodVO vo) {
		System.out.println("PostForFood DAO ��� : updateCnt");
		Object[] args = { vo.getPnum() };
		jdbcTemplate.update(updatePostSQL_Cnt, args);
	}

	public void updateCnt2(PostForFoodVO vo) {
		System.out.println("PostForFood DAO ��� : updateCnt2");
		Object[] args = { vo.getPnum() };
		jdbcTemplate.update(updatePostSQL_Cnt2, args);
	}

	// D �Խñ� ����
	public void deletePost(PostForFoodVO vo) {
		System.out.println("PostForFood DAO ��� : deletePost");
		Object[] args = { vo.getPnum() };
		jdbcTemplate.update(deletePostSQL, args);
	}

	// R - �Խñ� �󼼺���
	public PostForFoodVO getPost(PostForFoodVO vo) {
		System.out.println("PostForFood DAO ��� : PostForFoodVO");
		Object[] args = { vo.getPnum() };
		return jdbcTemplate.queryForObject(getPostSQL, args, new PostForFoodRowMapper());
	}

	// R - �Խñ� ����Ʈ
	public List<PostForFoodVO> getPostList(PostForFoodVO vo) {
		System.out.println("PostForFood DAO ��� : getPostList");
		return jdbcTemplate.query(getPostListSQL, new PostForFoodRowMapper());
	}

	// R - My �Խñ� ����Ʈ
	public List<PostForFoodVO> getMyPostList(PostForFoodVO vo) {
		System.out.println("PostForFood DAO ��� : getPostList");
		Object[] args = { vo.getMid() };
		return jdbcTemplate.query(getMyPostListSQL, args, new PostForFoodRowMapper());
	}

	// R - select all 2 �˻����
	/*
	 * public List<PostForFoodVO> searchPost(PostForFoodVO vo) {
	 * System.out.println("PostForFood DAO ��� : searchPost"); Object[] args = {
	 * vo.getKeyword() }; if (vo.getCondition().equals("title")) { return
	 * jdbcTemplate.query(searchPostSQL_Title, args, new PostForFoodRowMapper()); }
	 * else if(vo.getCondition().equals("nickname")) { return
	 * jdbcTemplate.query(searchPostSQL_Nickname, args, new PostForFoodRowMapper());
	 * }else{ return jdbcTemplate.query(searchPostSQL_Location, args, new
	 * PostForFoodRowMapper()); } }
	 */
// =================================================================================
	// PAGENATION
	// �Խ��� ��ü�ۼ��� ī�����ϴ� �޼���
	public int getPostCnt() {
		int total = jdbcTemplate.queryForObject(getPostCntSQL, Integer.class);
		System.out.println("getPostCnt=" + total);
		return total;
	}

	// pagenation�� ���� getList
	public List<PostForFoodVO> getPostListPagenation(int startRow, int endRow) {
		System.out.println("PostForFood DAO ��� : getPostListPagenation");
		String getPostPagenationSQL = "SELECT * FROM (SELECT ROWNUM AS RNUM, A.PNUM,A.MID,A.NICKNAME,A.TITLE,A.THUMNAIL,A.CONTENT,A.POSTCODE,A.ROADADDRESS,A.DETAILADDRESS,A.PHONE,A.LOCATION,A.CNT,A.HEART,A.WDATE FROM (SELECT * FROM POST_FOR_Food ORDER BY PNUM DESC) A) WHERE RNUM BETWEEN "
				+ startRow + " AND " + endRow;
		return jdbcTemplate.query(getPostPagenationSQL, new PostForFoodRowMapper());
	}

	// �Խñ� �˻� title
	public List<PostForFoodVO> getPostListTitleSearch(PostForFoodVO vo) {
		System.out.println("PostForFood DAO ��� : getPostListTitleSearch");
		Object[] args = {vo.getKeyword()};
		return jdbcTemplate.query(searchPostSQL_Title,args,new PostForFoodRowMapper());
	}

	// �Խñ� �˻� nickname
	public List<PostForFoodVO> getPostListNickSearch(PostForFoodVO vo) {
		System.out.println("PostForFood DAO ��� : getPostListNickSearch");
		Object[] args = { vo.getKeyword()};
		return jdbcTemplate.query(searchPostSQL_Nickname,args,new PostForFoodRowMapper());
	}

	// �Խñ� �˻�  location
	public List<PostForFoodVO> getPostListLocationSearch(PostForFoodVO vo) {
		System.out.println("PostForFood DAO ��� : getPostListLocationSearch");
		Object[] args = { vo.getKeyword()};
		return jdbcTemplate.query(searchPostSQL_Location,args,new PostForFoodRowMapper());
	}
}
