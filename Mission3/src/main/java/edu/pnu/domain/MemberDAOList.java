package edu.pnu.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberDAOList implements MemberDAO {
	
	static List<MemberVO> memberList;
	
	public static String stringdata() {
		Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
		return str;
	}
	
	public MemberDAOList() {
		memberList = new ArrayList<MemberVO>();		
		for(int i=1; i<=10;i++) {
			MemberVO member = new MemberVO("musthave"+i, "1234", "musthave"+i, stringdata());
			memberList.add(member);
		}
	}
	
	public List<MemberVO> getMembers(){	
		return memberList;
	}
	
	public MemberVO getMember(String id) {
		for(MemberVO t : memberList) {
			if(t.getId().equals(id)) {
				return t;
			}
		}
		return null;
	}
	
	public MemberVO addMember(MemberVO memberVO) {
		for(MemberVO t : memberList) {
			if(t.getId() == memberVO.getId()) {
				return null;
			}
		}
		memberVO.setRegidate(stringdata());
		memberList.add(memberVO);
		return memberVO;
	}
	
	public MemberVO updateMember(MemberVO memberVO) {
		for(MemberVO t : memberList) {
			if(t.getId().equals(memberVO.getId())) {
//				t.setPass("1234");
				t.setName("IDC"+ memberVO.getId());
//				t.setRegidate(new Date());
				return t;
			}
		}
		return null;
	}
	
	public MemberVO removeMember(String id) {
		MemberVO deleteId = null;
		for(MemberVO t : memberList) {
			if(t.getId().equals(id)) {
				deleteId = t;
				memberList.remove(t);
				return deleteId;
			}
		}
		return null;
		
	}

	@Override
	public String getSql() {
		// TODO Auto-generated method stub
		return null;
	}

}
