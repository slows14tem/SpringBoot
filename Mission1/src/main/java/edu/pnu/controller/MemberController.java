package edu.pnu.controller;

import java.util.Date;
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
	public MemberVO getMember(@PathVariable Integer id){
		return ms.getMember(id);
	}
	
	@PostMapping("/member")
	public MemberVO addMember(MemberVO memberVO){
		int id = 11;
		memberVO.setId(id);
		memberVO.setPass("1234");
		memberVO.setName("ID"+id);
		memberVO.setRegidate(new Date());
		return ms.addMember(memberVO);
	}
	
	@PutMapping("/member")
	public MemberVO updateMember(MemberVO memberVO) {
		int id = 10;
		memberVO.setId(id);
		return ms.updateMember(memberVO);
	}
	
	@DeleteMapping("/member/{id}")
	public MemberVO removeMember(@PathVariable Integer id){
		return ms.removeMember(id);
	}

}
