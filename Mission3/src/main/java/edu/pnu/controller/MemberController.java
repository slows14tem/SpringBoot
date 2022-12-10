package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	MemberService ms = new MemberService();
	
	@GetMapping("/member")
	public List<MemberVO> getMembers(){
//		ms.getLogs();	controller에서 함수를 두가지 이상 넣으면 안되는듯
		return ms.getMembers();
	}
	
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable String id){
		return ms.getMember(id);
	}

//	@GetMapping("/members")	//GetMapping마다 다른 url주소가 달라야함
//	public MemberVO getMember(String id){
//		return ms.getMember(id);
//	}	//이렇게 쓰면 쿼리스트링 ?id=으로 아이디를 검색할 수 있다.
	
	@PostMapping("/member")
	public MemberVO addMember(MemberVO memberVO){
		memberVO.setId("musthave4");
		memberVO.setPass("1234");
		memberVO.setName("musthave4");
		return ms.addMember(memberVO);
	}
	
	@PutMapping("/member")
	public MemberVO updateMember(MemberVO memberVO) {
		memberVO.setId("musthave4");
		memberVO.setName("머스트해브수정");
		return ms.updateMember(memberVO);
	}
	
	@DeleteMapping("/member/{id}")
	public MemberVO removeMember(@PathVariable String id){
		return ms.removeMember(id);
	}

}
