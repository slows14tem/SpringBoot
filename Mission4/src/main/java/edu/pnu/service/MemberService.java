package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.LogDAO;
import edu.pnu.domain.MemberDAO;
import edu.pnu.domain.MemberVO;

@Service
//@configuration
public class MemberService {
//	MemberDAO dao = new MemberDAOH2();
//	MemberDAO dao = new MemberDAOList();
//	LogDAO log = new LogDAO();
	
//	@Bean
//	public LogDAO log() {
//		return new LogDAO();
//	}	@Configuration과 @Bean으로 @Repository와 @Autowired를 대체할 수 있다
	
	@Autowired
	private MemberDAO dao;
	@Autowired
	private LogDAO log;

	public List<MemberVO> getMembers(){
		List<MemberVO> m = dao.getMembers();
		if (m != null) {
			log.insertLog("Get", dao.getSql(), true);
			return m;
		} else {
			log.insertLog("Get", dao.getSql(), false);
			return null;
		}
	}
	
	public MemberVO getMember(String id) {
		MemberVO m = dao.getMember(id);
		if (m != null) {
			//성공로그
			log.insertLog("Get", dao.getSql(), true);
			return m;
		} else {
			//실패로그
			log.insertLog("Get", dao.getSql(), false);
			return null;
		}
	}
	
	public MemberVO addMember(MemberVO memberVO) {	//post
		
		MemberVO m = dao.addMember(memberVO);
		if (m != null) {
			//성공로그
			log.insertLog("Post", dao.getSql(), true);
			return m;
		} else {
			//실패로그
			log.insertLog("Post", dao.getSql(), false);
			return null;
		}
	}
	
	public MemberVO updateMember(MemberVO memberVO) {	//put
		MemberVO m = dao.updateMember(memberVO);
		if (m != null) {
			//성공로그
			log.insertLog("Put", dao.getSql(), true);
			return m;
		} else {
			//실패로그
			log.insertLog("Put", dao.getSql(), false);
			return null;
		}
	}
	
	public MemberVO removeMember(String id) {	//delete
		MemberVO m = dao.removeMember(id);
		if (m != null) {
			//성공로그
			log.insertLog("Delete", dao.getSql(), true);
			return m;
		} else {
			//실패로그
			log.insertLog("Delete", dao.getSql(), false);
			return null;
		}
	}
}
