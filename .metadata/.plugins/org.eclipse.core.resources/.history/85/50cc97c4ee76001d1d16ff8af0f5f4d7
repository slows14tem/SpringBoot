package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

@SessionAttributes("member")
@Controller
public class LoginController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public void loginView() {
		
	}
	
	@PostMapping("/login")
	public String login(Member member, Model model) {
		Member findMember = memberService.getMember(member);
		
		if(findMember != null && findMember.getPassword().equals(member.getPassword())) {
			model.addAttribute("member", findMember);
			return "forward:getBoardList";
		} else {
			return "redirect:login";
		}
	}
	//redirect는 get method로 전송??
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:index.html";
	}
	
	@GetMapping("/join")
	public void joinView() {
		
	}
	
	@PostMapping("/join")
	public String join(Member member, Model model) {
		Member findMember = memberService.join(member);
		if(findMember == null) {
			model.addAttribute("member", member);
			return "forward:getBoardList";
		} else return "redirect:login";
	}
	
	@GetMapping("/update")
	public void updateView() {
		
	}
	
	@PostMapping("/update")
	public String update(Member member, Model model) {
		Member findMember = memberService.update(member);
		if (findMember != null) {
			model.addAttribute("member", member);
			return "forward:getBoardList";
		} else return "redirect:update";
	}
	
	@GetMapping("/delete")
	public String delete(Member member, SessionStatus status) {
		memberService.delete(member);
		status.setComplete();
		return "redirect:index.html";
	}

}
