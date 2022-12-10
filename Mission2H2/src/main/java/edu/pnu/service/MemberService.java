package edu.pnu.service;

import java.util.List;

import edu.pnu.domain.MemberDAO;
import edu.pnu.domain.MemberVO;

public class MemberService {
	MemberDAO dao = new MemberDAO();
	
	public List<MemberVO> getMembers(){
		return dao.getMembers();
	}
	
	public MemberVO getMember(String id) {
		return dao.getMember(id);
	}
	
	public MemberVO addMember(MemberVO memberVO) {
		return dao.addMember(memberVO);
	}
	
	public MemberVO updateMember(MemberVO memberVO) {
		return dao.updateMember(memberVO);
	}
	
	public MemberVO removeMember(String id) {
		return dao.removeMember(id);
	}
}
