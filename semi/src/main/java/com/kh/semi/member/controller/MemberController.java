package com.kh.semi.member.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.semi.auth.model.vo.CustomUserDetails;
import com.kh.semi.member.model.dto.MemberDto;
import com.kh.semi.member.model.dto.UpdatePasswordDto;
import com.kh.semi.member.model.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	
	@PostMapping
	public ResponseEntity<Void> signUp(@RequestBody @Valid MemberDto member) {
		// log.info("body : {}", member);
		memberService.signUp(member);
		return ResponseEntity.status(201).build();
	}
	
	/*
	 * 로그인 -> 인증(Authentication)
	 * 
	 * 회원이 아이디랑 비밀번호를 입력해서 로그인 요청을 보냄
	 * 
	 * -> 서버는 DB에서 사용자 정보가 일치하는 지 검증
	 * -> 아이디만 확인
	 * -> 아이디가 일치하는 회원의 정보를 서비스로 반환
	 * -> PasswordEncoder.matches(평문, 암호문)
	 * -> 일치하면 사용자 정보를 HttpSession(서버 메모리)에 저장
	 * 
	 * 서버는 응답 헤더의 Set-Cookie: JESSIONID=~~~를 클라이언트에게 응답
	 * 다음 요청부터 클라이언트는 같은 도메인이라면 Cookie:JESSIONID=~~~를 같이 보내서
	 * 
	 * 1. 인증된 사용자의 다음 요청은 반드시 그 사용자의 세션이 살아있는 같은 서버 인스턴스로 다시 돌아온다
	 * 2. 클라이언트는 쿠키를 자동으로 보관하고 자동으로 실어 보낼 능력이 있다.
	 * 
	 * 한계 1 : 서버가 두 대로 늘어나면 무엇이 무너지는가 => 스티키 세션(sticky session)
	 * 1. 부하 불균형
	 * 2. 인스턴스 장애에 대한 직접 노출
	 * 3. 무중단 배포의 어려움
	 * 
	 * 한계 2 : 브라우저가 아닌 클라이언트
	 * 
	 * 1. 모바일 앱(IOS/Android) : URLSession, OkHttp(CookieJar) -> 앱이 종료되거나 다시 설치되면 쿠키 저장소가 초기화
	 * 2. 분리 배보된 SPS(React, Vue) -> 같은 출처가 아님 (같은 출처 : 프로토콜, 도메인, 포트가 모두 같은 경우)
	 * 
	 * 
	 * 
	 * => 토큰 기반 인증방식 도입
	 * ==> 서버가 클라이언트의 정보를 계속 들고있다 => 인증된 사용자의 정보를 서버에서 보관하지 말자 => 토클기반 인증 방식
	 * 
	 * => JWT가 표준 구현
	 * 
	 * 1. 표준사양
	 * 2. 언어중립
	 * 3. 내용이 자체 포함
	 * 4. JSON기반
	 * ----------------------------------------------------
	 * 
	 * => 문제점
	 * 
	 * 1. 탈취 => 토큰의 만료시간을 굉장히 짧게
	 * 2. 갱신 => 토큰을 두 개 사용
	 * 3. 로그아웃 => 답이 없음
	 * -----------------------------------------------
	 * 
	 * 세션방식 <==> 토큰방식
	 */
	
	// 비밀번호 변경
	@PatchMapping
	public ResponseEntity<Void> changePassword(@AuthenticationPrincipal CustomUserDetails user,
											@RequestBody @Valid UpdatePasswordDto upd) {
		// 1. 아이디, 비밀번호, 변경 비밀번호
		// 2. 비밀번호값에 대한 유효성 검증
		// 3. 지금 요청을 보낸 사용자가 입력한 기존의 비밃번호가 DB에 저장된 거랑 매칭이 잘 되는 지 확인
		// 4. 새로 입력한 비밀번호에 대한 암호화작업
		// 5. DB에 가서 UPDATE
		
		log.info("요청 확인 : {} | {}", user, upd);
		memberService.changePassword(user, upd);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteByPassword(@RequestBody Map<String, String> password,
												 @AuthenticationPrincipal CustomUserDetails user) {
		memberService.deleteByPassword(password.get("password"), user);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
