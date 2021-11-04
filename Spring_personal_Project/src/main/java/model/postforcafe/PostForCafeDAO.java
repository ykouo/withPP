package model.postforcafe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class PostForCafeRowMapper implements RowMapper<PostForCafeVO> {
	@Override
	public PostForCafeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PostForCafeVO vo = new PostForCafeVO();
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

@Repository
public class PostForCafeDAO {

	// SQL문
	private final String insertPostSQL = "INSERT INTO POST_FOR_CAFE (PNUM,MID,NICKNAME,TITLE,THUMNAIL,CONTENT,POSTCODE,ROADADDRESS,DETAILADDRESS,PHONE,LOCATION) VALUES ((SELECT NVL(MAX(PNUM),0)+1 FROM POST_FOR_CAFE),?,?,?,?,?,?,?,?,?,?)";
	private final String insertPostSQLNothumnail = "INSERT INTO POST_FOR_CAFE (PNUM,MID,NICKNAME,TITLE,THUMNAIL,CONTENT,POSTCODE,ROADADDRESS,DETAILADDRESS,PHONE,LOCATION) VALUES ((SELECT NVL(MAX(PNUM),0)+1 FROM POST_FOR_CAFE),?,?,?,'images/thumnail.png',?,?,?,?,?,?)";
	private final String updatePostSQL = "UPDATE POST_FOR_CAFE SET NICKNAME=?,TITLE=?,THUMNAIL=?,CONTENT=?,POSTCODE=?,ROADADDRESS=?,DETAILADDRESS=?,PHONE=?,LOCATION=? WHERE PNUM=?";
	private final String updatePostSQL_Heart = "UPDATE POST_FOR_CAFE SET HEART=? WHERE PNUM=?";
	private final String updatePostSQL_Cnt = "UPDATE POST_FOR_CAFE SET CNT=CNT+1 WHERE PNUM=?";
	private final String updatePostSQL_Cnt2 = "UPDATE POST_FOR_CAFE SET CNT=CNT-1 WHERE PNUM=?";
	private final String deletePostSQL = "DELETE FROM POST_FOR_CAFE WHERE PNUM=?";
	private final String getPostSQL = "SELECT * FROM POST_FOR_CAFE WHERE PNUM=?";
	private final String getPostListSQL = "SELECT * FROM POST_FOR_CAFE ORDER BY PNUM DESC";
	private final String getMyPostListSQL = "SELECT * FROM POST_FOR_CAFE WHERE MID=? ORDER BY PNUM DESC";
	private final String getPostCntSQL = "SELECT COUNT(*) FROM POST_FOR_CAFE";
	private final String searchPostSQL_Title = "SELECT * FROM POST_FOR_CAFE WHERE TITLE LIKE '%'||?||'%' ORDER BY PNUM DESC";
	private final String searchPostSQL_Nickname = "SELECT * FROM POST_FOR_CAFE WHERE LOCATION LIKE '%'||?||'%' ORDER BY PNUM DESC";
	private final String searchPostSQL_Location = "SELECT * FROM POST_FOR_CAFE WHERE NICKNAME LIKE '%'||?||'%' ORDER BY PNUM DESC";

	// jdbcTemplate 추가
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 메서드
	// C 게시글 추가
	public void insertPost(PostForCafeVO vo) {
		System.out.println("PostForCafe DAO 출력 : insertPost " + vo);
		Object[] args = { vo.getMid(), vo.getNickname(), vo.getTitle(), vo.getThumnail(), vo.getContent(),
				vo.getPostcode(), vo.getRoadaddress(), vo.getDetailaddress(), vo.getPhone(), vo.getLocation() };
		jdbcTemplate.update(insertPostSQL, args);
	}

	public void insertPostNoTumnail(PostForCafeVO vo) {
		System.err.println("PostForCafe DAO 출력 : insertPost ");
		System.out.println("PostForCafe DAO 출력 : insertPost " + vo);
		Object[] args = { vo.getMid(), vo.getNickname(), vo.getTitle(), vo.getContent(), vo.getPostcode(),
				vo.getRoadaddress(), vo.getDetailaddress(), vo.getPhone(), vo.getLocation() };
		jdbcTemplate.update(insertPostSQLNothumnail, args);
	}

	// U 게시글 수정
	public void updatePost(PostForCafeVO vo) {
		System.out.println("PostForCafe DAO 출력 : updatePost");
		Object[] args = { vo.getNickname(), vo.getTitle(), vo.getThumnail(), vo.getContent(), vo.getPostcode(),
				vo.getRoadaddress(), vo.getDetailaddress(), vo.getPhone(), vo.getLocation(), vo.getPnum() };
		jdbcTemplate.update(updatePostSQL, args);
	}

	public void updateHeart(PostForCafeVO vo) {
		System.out.println("PostForCafe DAO 출력 : updateHeart");
		Object[] args = { vo.getHeart(), vo.getPnum() };
		jdbcTemplate.update(updatePostSQL_Heart, args);
	}

	public void updateCnt(PostForCafeVO vo) {
		System.out.println("PostForCafe DAO 출력 : updateCnt");
		Object[] args = { vo.getPnum() };
		jdbcTemplate.update(updatePostSQL_Cnt, args);
	}

	public void updateCnt2(PostForCafeVO vo) {
		System.out.println("PostForCafe DAO 출력 : updateCnt2");
		Object[] args = { vo.getPnum() };
		jdbcTemplate.update(updatePostSQL_Cnt2, args);
	}

	// D 게시글 삭제
	public void deletePost(PostForCafeVO vo) {
		System.out.println("PostForCafe DAO 출력 : deletePost");
		Object[] args = { vo.getPnum() };
		jdbcTemplate.update(deletePostSQL, args);
	}

	// R - 게시글 상세보기
	public PostForCafeVO getPost(PostForCafeVO vo) {
		System.out.println("PostForCafe DAO 출력 : PostForCafeVO");
		Object[] args = { vo.getPnum() };
		return jdbcTemplate.queryForObject(getPostSQL, args, new PostForCafeRowMapper());
	}

	// R - 게시글 리스트
	public List<PostForCafeVO> getPostList(PostForCafeVO vo) {
		System.out.println("PostForCafe DAO 출력 : getPostList");
		return jdbcTemplate.query(getPostListSQL, new PostForCafeRowMapper());
	}

	// R - My 게시글 리스트
	public List<PostForCafeVO> getMyPostList(PostForCafeVO vo) {
		System.out.println("PostForCafe DAO 출력 : getPostList");
		Object[] args = { vo.getMid() };
		return jdbcTemplate.query(getMyPostListSQL, args, new PostForCafeRowMapper());
	}

	// R - select all 2 검색기능
	/*
	 * public List<PostForCafeVO> searchPost(PostForCafeVO vo) {
	 * System.out.println("PostForCafe DAO 출력 : searchPost"); Object[] args = {
	 * vo.getKeyword() }; if (vo.getCondition().equals("title")) { return
	 * jdbcTemplate.query(searchPostSQL_Title, args, new PostForCafeRowMapper()); }
	 * else if(vo.getCondition().equals("nickname")) { return
	 * jdbcTemplate.query(searchPostSQL_Nickname, args, new PostForCafeRowMapper());
	 * }else{ return jdbcTemplate.query(searchPostSQL_Location, args, new
	 * PostForCafeRowMapper()); } }
	 */
// =================================================================================
	// PAGENATION
	// 게시판 전체글수를 카운팅하는 메서드
	public int getPostCnt() {
		int total = jdbcTemplate.queryForObject(getPostCntSQL, Integer.class);
		System.out.println("getPostCnt=" + total);
		return total;
	}

	// pagenation을 위한 getList
	public List<PostForCafeVO> getPostListPagenation(int startRow, int endRow) {
		System.out.println("PostForCafe DAO 출력 : getPostListPagenation");
		String getPostPagenationSQL = "SELECT * FROM (SELECT ROWNUM AS RNUM, A.PNUM,A.MID,A.NICKNAME,A.TITLE,A.THUMNAIL,A.CONTENT,A.POSTCODE,A.ROADADDRESS,A.DETAILADDRESS,A.PHONE,A.LOCATION,A.CNT,A.HEART,A.WDATE FROM (SELECT * FROM POST_FOR_CAFE ORDER BY PNUM DESC) A) WHERE RNUM BETWEEN "
				+ startRow + " AND " + endRow;
		return jdbcTemplate.query(getPostPagenationSQL, new PostForCafeRowMapper());
	}

	// 게시글 검색 title
	public List<PostForCafeVO> getPostListTitleSearch(PostForCafeVO vo) {
		System.out.println("PostForCafe DAO 출력 : getPostListTitleSearch");
		Object[] args = {vo.getKeyword()};
		return jdbcTemplate.query(searchPostSQL_Title,args,new PostForCafeRowMapper());
	}

	// 게시글 검색 nickname
	public List<PostForCafeVO> getPostListNickSearch(PostForCafeVO vo) {
		System.out.println("PostForCafe DAO 출력 : getPostListNickSearch");
		Object[] args = { vo.getKeyword()};
		return jdbcTemplate.query(searchPostSQL_Nickname,args,new PostForCafeRowMapper());
	}

	// 게시글 검색  location
	public List<PostForCafeVO> getPostListLocationSearch(PostForCafeVO vo) {
		System.out.println("PostForCafe DAO 출력 : getPostListLocationSearch");
		Object[] args = { vo.getKeyword()};
		return jdbcTemplate.query(searchPostSQL_Location,args,new PostForCafeRowMapper());
	}
}
