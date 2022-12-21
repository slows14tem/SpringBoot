시큐리티 로그인(시큐리티 스타터 지원)
	프로젝트 생성 때 spring security 필요
	ID: user
	Using generated security password: 791214c6-8ead-4294-90a7-f61da28848a3(콘솔에 출력됨)
	
시큐리티 커스터마이징
	SecurityFilterChain클래스에서 제공하는 다양한 기능을 가진 필터들 
	//특정 URL 경로에 권한을 가진 사용자만 접근을 허용
		http.authorizeHttpRequests()
			.requestMatchers("/member/**").authenticated()	//인증된 사용자의 접근을 허용
			.requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN") //사용자가 주어진 어떤권한이라도 있으면 허용
			.requestMatchers("/admin/**").hasRole("ADMIN")	//사용자가 주어진 역할이 있다면 접근을 허용
			.anyRequest().permitAll();	//무조건 허용
	
	//크로스 위조요청 설정 비활성화(RESTfull 사용하기 위해)
		http.csrf().disable();
	
	//사용자 정의 로그인 화면을 띄우고 싶을 때
		http.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/loginSuccess", true);
			
	//접근권한 없음 페이지 설정
		http.exceptionHandling().accessDeniedPage("/accessDenied");
		
	//현제 브라우저와 연관된 세션을 강제종료(로그 아웃)
		http.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");
		
	//인증관리 필터 검증을 위한 UserDetailsService 구현(JPA Repository와 연동하기 위한 방법)
		http.userDetailsService(boardUserDetailsService);
		인증관리필터가 사용자가 입력한 정보를 토대로 기능을 처리하기위해서는 사용자 정보가 저장된 UserDetails객체가 필요
		UserDetails 객체에 실제 데이터베이스에서 검색한 사용자정보를 저장하는 UserDetailsService객체도 필요
		UserDetailsService객체를 통해 UserDetails객체를 획득
	

@Configuration 안에서 @Bean이 빈으로 등록되는 과정
	스프링 컨테이너는 @Configuration이 붙어있는 클래스를 자동으로 빈으로 등록해두고, 해당 클래스를 파싱해서 @Bean이 있는 메소드를 찾아서 빈을 생성해준다.
	하지만 어떤 임의의 클래스를 만들어서 @Bean 어노테이션을 붙인다고 되는 것이 아니고, 
	@Bean을 사용하는 클래스에는 반드시 @Configuration 어노테이션을 활용하여 해당 클래스에서 Bean을 등록하고자 함을 명시해주어야 한다.
	이러한 @Bean 어노테이션의 경우는 수동으로 빈을 직접 등록해줘야만 하는 상황인데, 주로 다음과 같을 때 사용한다.
		1. 개발자가 직접 제어가 불가능한 라이브러리를 활용할 때
		2. 애플리케이션 전범위적으로 사용되는 클래스를 등록할 때
		3. 다형성을 활용하여 여러 구현체를 등록해주어야 할 때


	
Spring Security 5.7.0-M2 부터 해당 클래스는 컴포넌트 기반의 보안 설정을 권장한다는 이유로 WebSecurityConfigurerAdapter클래스는 Deprecated 처리
대신에 SecurityFilterChain을 사용하기를 권장
SecurityFilterChain을 반환하고 빈으로 등록함으로써 컴포넌트 기반의 보안 설정이 가능해진다.