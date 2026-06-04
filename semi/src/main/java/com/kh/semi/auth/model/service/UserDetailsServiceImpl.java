package com.kh.semi.auth.model.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.semi.auth.model.dao.AuthMapper;
import com.kh.semi.auth.model.vo.CustomUserDetails;
import com.kh.semi.member.model.dto.MemberDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final AuthMapper authMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// log.info("username => {}", username);
		// 여기선 무엇을 해야하는가
		MemberDto user = authMapper.loadUser(username);
		
		// log.info("조회된 정보 : {}", user);
		
		if(user == null) {
			throw new UsernameNotFoundException("UserNameNotFound");
		}
		
		return CustomUserDetails.builder()
					  			.username(user.getMemberId())
					  			.password(user.getMemberPwd())
					  			.memberName(user.getMemberName())
					  			.authorities(Collections.singletonList(new SimpleGrantedAuthority(user.getRole())))
					  			.status(user.getStatus())
					  			.build();
	}
	
}
