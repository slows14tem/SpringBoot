package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import edu.pnu.domain.MemberVO;

public class MemberService {
	
	public List<MemberVO> memberList;
	
	public MemberService() {
		memberList = new ArrayList<MemberVO>();		
		for(int i=1; i<=10;i++) {
			MemberVO member = new MemberVO(i, "1234", "아이디"+i, new Date());
			memberList.add(member);
		}
	}
	
	public List<MemberVO> getMembers(){	
		return memberList;
	}
	
	public MemberVO getMember(int id) {
		for(MemberVO t : memberList) {
			if(t.getId() == id) {
				return memberList.get(id-1);
			}
		}
		return null;
	}
	
	public MemberVO addMember(MemberVO memberVO) {
		for(MemberVO t : memberList) {
			if(t.getId() == memberVO.getId()) {
				memberVO.setId(memberVO.getId()+1);
			}
		}
		memberList.add(memberVO);
		return memberVO;
	}
	
	public MemberVO updateMember(MemberVO memberVO) {
		for(MemberVO t : memberList) {
			if(t.getId() == memberVO.getId()) {
//				t.setPass("1234");
				t.setName("IDC"+ memberVO.getId());
//				t.setRegidate(new Date());
			}
		}
		return memberList.get(memberVO.getId()-1);
	}
	
	public MemberVO removeMember(int id) {
		MemberVO deleteId = null;
		for(MemberVO t : memberList) {
			if(t.getId() == id) {
				deleteId = t;
				memberList.remove(t);
				return deleteId;
			}
		}
		return null;
		
	}

}
