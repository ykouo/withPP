package model.member;

import java.util.List;



public interface MemberService {

	void insertMember(MemberVO vo);
	void insertNoImageMember(MemberVO vo);
	void insertAdmin(MemberVO vo);
	void updateMember(MemberVO vo);
	void updatePwMember(MemberVO vo);
	void deleteMember(MemberVO vo);
	MemberVO getMember(MemberVO vo);
	MemberVO searchMember(MemberVO vo); 
	List<MemberVO> getMemberList(MemberVO vo);
	MemberVO checkMember(MemberVO vo);
	MemberVO checkID(MemberVO vo);
}
 