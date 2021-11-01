package model.member;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

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
		System.out.println("여기 도착했니?1 그럼 vo : "+ vo);
		return memberDAO.checkMember(vo);
	}

	@Override
	public void insertNoImageMember(MemberVO vo) {
		memberDAO.insertNoImageMember(vo);
		
	}

}
