package com.kh.semi.configuration.filter;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.kh.semi.auth.model.vo.CustomUserDetails;
import com.kh.semi.token.util.JwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
	
	private final JwtUtil jwtUtil;
	private final UserDetailsService userDetailService;
	
	// 이 안에서 반환하는 경로들은 필터를 아예 안타게 해주는 메소드
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		String uri = request.getRequestURI();
		String method = request.getMethod();
		
		if("GET".equals(method) && uri.startsWith("/api/boards")) return true;
		if("GET".equals(method) && uri.startsWith("/api/comments")) return true;
		
		return uri.equals("/api/auth/login") || uri.equals("/api/auth/refresh");
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
		
		// 토큰이 존재하지 않거나 형식이 깨졌으면 통과
		if(authorization == null || !authorization.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		log.info("authorization : {}", authorization);
		
		/*
		String uri = request.getRequestURI();
		if(uri.equals("/api/auth/login")) {
			filterChain.doFilter(request, response);
			return;
		}
		*/
		
		String token = authorization.substring(7);
		
		try {
			Claims claims = jwtUtil.parseJwt(token);
			String username = claims.getSubject();
			// log.info("토큰 소유주의 PK : {}", username);
			
			CustomUserDetails user = (CustomUserDetails)userDetailService.loadUserByUsername(username);
			// log.info("user : {}", user);
			
			UsernamePasswordAuthenticationToken authentication 
				= new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			// 세부 설정 관련들 사용자의 IP주소, MAC주소, sessionId등을 포함시켜서 셋팅
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			// 현재 요청이 만료될때까지 Authentication에 담겨있는 사용자의 정보를 사용할 수 있음
			
		} catch (ExpiredJwtException e) {
			log.info("토큰의 유효기간 만료");
			response.setStatus(401);
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().write("토큰만료");
			return;
		} catch (JwtException e) {
			log.info("이 서버의 서비스키로 만든 토큰이 아님");
			response.setStatus(401);
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().write("유효하지 않은 토큰");
			return;
		}
		
		filterChain.doFilter(request, response);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
