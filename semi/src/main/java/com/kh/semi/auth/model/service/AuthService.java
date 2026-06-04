package com.kh.semi.auth.model.service;

import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.kh.semi.auth.model.dto.LoginRequestDto;
import com.kh.semi.auth.model.dto.LoginResponse;
import com.kh.semi.auth.model.vo.CustomUserDetails;
import com.kh.semi.exception.CustomAuthenticationException;
import com.kh.semi.token.model.service.TokenService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {
	
	private final AuthenticationManager authenticationManager;
	private final TokenService tokenService;
	
	public LoginResponse login(LoginRequestDto lrd) {
		// 로그인(인증/Authentication) 구현
		
		// 1. 유효성검증(아이디 / 비밀번호값이 들어왔는가, 영어숫자인가, 글자수가 괜찮은가) -> @Valid로 대체
		// 2. 아이디가 SEMI_MEMBER테이블에 MEMBER_ID컬럼에 존재하는 아이디인가
		// 3. 조회를 해온 비밀번호 컬럼의 암호문이 사용자가 입력한 평문으로 만들어진것이 맞는가
		
		Authentication auth = null;
		try {
			auth = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(lrd.getMemberId(), lrd.getMemberPwd()));
		} catch (AuthenticationException e) {
			throw new CustomAuthenticationException("아이디 또는 비밀번호가 다릅니다.");
		}
		
		CustomUserDetails user = (CustomUserDetails)auth.getPrincipal();
		// log.info("CustomUserDetails = {}", user);
		// 토큰 만들어서 발급
		Map<String, String> tokens = tokenService.getTokens(user);
		
		return LoginResponse.builder()
							.memberId(user.getUsername())
							.memberName(user.getMemberName())
							.role(user.getAuthorities().toString())
							.accessToken(tokens.get("accessToken"))
							.refreshToken(tokens.get("refreshToken"))
							.build();
		
	}
	
	
	
}
