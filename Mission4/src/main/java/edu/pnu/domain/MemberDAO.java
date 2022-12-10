package edu.pnu.domain;

import java.util.List;

public interface MemberDAO {
	
	public List<MemberVO> getMembers();
	
	public MemberVO getMember(String id);
	
	public MemberVO addMember(MemberVO memberVO);
	
	public MemberVO updateMember(MemberVO memberVO);
	
	public MemberVO removeMember(String id);
	
	public String getSql();

}
