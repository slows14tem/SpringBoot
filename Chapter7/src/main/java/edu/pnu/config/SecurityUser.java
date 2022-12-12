package edu.pnu.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import edu.pnu.domain.Member;

public class SecurityUser extends User {

	public SecurityUser(Member member) {
		super(member.getId(), "{noop}" + member.getPassword(), AuthorityUtils.createAuthorityList(member.getRole().toString()));
		// TODO Auto-generated constructor stub
	}

}
