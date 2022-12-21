package edu.pnu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	//교제 413페이지 새버전 변경된 방법
	
	@Autowired
	private BoardUserDetailsService boardUserDetailsService;
	
	@Bean	//@configuration/@Bean 어노테이션이 있으면 메소드에서 리턴된 객체(new ~~~)가 메모리에 올라감
			//소스가 없는 객체를 메모리에 올릴 때 사용??
	public SecurityFilterChain sercurityFilterChain(HttpSecurity http) throws Exception {
		
		//Cross site Request forgery(사이트 간 위조 요청)
		//CSRF protection은 spring security에서 default로 설정된다. 
		//즉, protection을 통해 GET요청을 제외한 상태를 변화시킬 수 있는 POST, PUT, DELETE 요청으로부터 보호한다.
		//non-browser clients 만을 위한 서비스(rest api)라면 csrf를 disable 하여도 좋다고 한다.
		//https://velog.io/@woohobi/Spring-security-csrf%EB%9E%80
		http.csrf().disable();
		
		http.userDetailsService(boardUserDetailsService);	//시큐리티의 기본 UserDetailsService서비스가 아닌
		//사용자 정의 UserDetailsService를 사용할 수 있게 변경함
		
		//특정 경로에 권한을 가진 사용자만 접근을 허용
		http.authorizeHttpRequests()
			.requestMatchers("/", "/system/**").permitAll()	//무조건 허용
			.requestMatchers("/board/**").authenticated()	//인증된 사용자의 접근을 허용
			.requestMatchers("/admin/**").hasRole("ADMIN");	//사용자가 주어진 역할이 있다면 접근을 허용
		
		//사용자 정의 로그인 화면을 띄우고 싶을 때
		http.formLogin()
			.loginPage("/system/login")
			.defaultSuccessUrl("/board/getBoardList", true);
		
		//접근권한 없음 페이지
		http.exceptionHandling().accessDeniedPage("/system/accessDenied");
		
		//현제 브라우저와 연관된 세션을 강제종료(로그 아웃)
		http.logout().logoutUrl("/system/logout").invalidateHttpSession(true).logoutSuccessUrl("/");
		
		
		return http.build();
	}
	
	//비밀번호 암호화
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		//BCryptPasswordEncoder 객체를 리턴
		//사용 => private PasswordEncoder encoder; + m.setPassword(encoder.encode("manager456"));
	}


}
