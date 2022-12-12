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

//	@Autowired
//	private DataSource dataSource;
	
	@Autowired
	private BoardUserDetailsService boardUserDetailsService;
	
	@Bean	//@configuration/@Bean 어노테이션이 있으면 메소드에서 리턴된 객체(new ~~~)가 메모리에 올라감
			//소스가 없는 객체를 메모리에 올릴 때 사용??
	public SecurityFilterChain sercurityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		
		//특정 경로에 권한을 가진 사용자만 접근을 허용
		http.authorizeHttpRequests()
			.requestMatchers("/member/**").authenticated()	//member 요청은 authenticated되야한다
			.requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN")
			.requestMatchers("/admin/**").hasRole("ADMIN")
			.anyRequest().permitAll();
		
		//원하는 로그인 화면을 띄우고 싶을 때
		http.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/loginSuccess", true);
		
		//접근권한 없음 페이지
		http.exceptionHandling().accessDeniedPage("/accessDenied");
		
		//현제 브라우저와 연관된 세션을 강제종료
		http.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");
		
		//사용자가 정의한 UserDetailsService를 사용
		//	아래의 authenticate 메소드 삭제
		//	BoardUserDetailsService객체 의존성 주입
		http.userDetailsService(boardUserDetailsService);	//시큐리티의 기본 UserDetailsService서비스가 아닌
															//사용자 정의 UserDetailsService를 사용할 수 있게 변경함
		
		return http.build();
	}
	
	//비밀번호 암호화
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		//BCryptPasswordEncoder 객체를 리턴
		//사용 => private PasswordEncoder encoder; + m.setPassword(encoder.encode("manager456"));
	}
	
	
	//메모리로 사용자 인증하기
//	@Autowired
//	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("manager")
//		.password("{noop}manager123")	//noop = 비밀번호 암호화 안함
//		.roles("MANAGER");
//		
//		auth.inMemoryAuthentication()
//		.withUser("admin")
//		.password("{noop}admin123")
//		.roles("ADMIN");
//	}
	
	
	//데이터베이스에 저장된 회원정보로 인증하기 위한 설정
//	@Autowired
//	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
//		//유저 정보 불러오기
//		String query1 = "select id username, concat('{noop}', password) password, true enabled from member where id=?";
//		//유저 권한 불러오기
//		String qyery2 = "select id, role from member where id=?";
//		
//		auth.jdbcAuthentication()
//		.dataSource(dataSource)
//		.usersByUsernameQuery(query1)
//		.authoritiesByUsernameQuery(qyery2);
//	}

}
