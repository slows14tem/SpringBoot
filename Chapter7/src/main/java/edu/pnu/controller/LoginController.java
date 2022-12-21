package edu.pnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/login")
	public void login() {
		//뷰를 사용할 때 리턴이 url과 같으면 리턴 없어도 맞는 html페이지 로드해준다.
	}
	
	@GetMapping("/loginSuccess")
	public void loginSuccess() {
	}

}
