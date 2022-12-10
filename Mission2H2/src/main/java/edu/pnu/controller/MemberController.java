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
	public List<MemberVO> getMember(){
		return ms.getMembers(); 		
	}
	
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable String id){
		return ms.getMember(id);
	}
	
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
