package edu.pnu.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@Service
public class BoardUserDetailsService implements UserDetailsService {
	@Autowired
	private MemberRepository memberRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// MemberRepository로 회원 정보를 조회하여
		// UserDetails 타입의 객체로 리턴한다.
		Optional<Member> optional = memberRepo.findById(username);
		if(!optional.isPresent()) {
			throw new UsernameNotFoundException(username+"사용자 없음");
		} 
		//loadUserByUsername메소드는 사용자 아이디를 매개변수로 받아서 회원정보를 조회
		//loadUserByUsername 메소드의 리턴타입이 UserDetails인라서 MemberRepository로 검색한 유저정보를 리턴할 수 없다.
		//그래서 UserDetails인터페이스를 구현한 User 클래스를 상속하는 securityUser를 생성하여 loadUserByUsername함수의
		//		리턴타입으로 활용
		else {
			Member member = optional.get();
			return new SecurityUser(member);
		}
		
		
		//securityUser를 생성하지 않고 다음과 같이 사용할 수도 있다.
//		Member m = optional.get();
//		return new User(m.getId(), "{noop}"+m.getPassword(), AuthorityUtils.createAuthorityList(m.getRole().toString()));
//		String roleM = m.getRole().toString().split("_")[1];
//		return User.builder()
//				.username(m.getId())
//				.password("{noop}" + m.getPassword())
//				//roles에 "ROLE_"이 들어가 있으면 오류 발생
//				.roles(roleM)
//				.build();

	}

}
