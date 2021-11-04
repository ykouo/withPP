package model.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public void insertMember(MemberVO vo) {
		memberDAO.insertMember(vo);		
	}

	@Override
	public void insertAdmin(MemberVO vo) {
		memberDAO.insertAdmin(vo);
	}

	@Override
	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);
	}
 
	@Override
	public void deleteMember(MemberVO vo) {
		memberDAO.deleteMember(vo);
	}

	@Override
	public MemberVO getMember(MemberVO vo) {
		System.out.println("ServiceIMPL에서 동작 : getMember");
		System.out.println("vo : " + vo);
		return memberDAO.getMember(vo);
	}

	@Override
	public List<MemberVO> getMemberList(MemberVO vo) {
		return memberDAO.getMemberList(vo);
	}

	@Override
	public MemberVO checkMember(MemberVO vo) {
		return memberDAO.checkMember(vo);
	}

	@Override
	public void insertNoImageMember(MemberVO vo) {
		memberDAO.insertNoImageMember(vo);
		
	}

	@Override
	public MemberVO searchMember(MemberVO vo) {	
		return memberDAO.searchMember(vo);
	}

	@Override
	public void updatePwMember(MemberVO vo) {
		memberDAO.updatePwMember(vo);
		
	}

	@Override
	public MemberVO checkID(MemberVO vo) {		
		return memberDAO.checkID(vo);
	}

}
