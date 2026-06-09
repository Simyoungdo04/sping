package com.kh.semi.configuration;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.kh.semi.configuration.filter.JwtFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final JwtFilter jwtFilter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// return http.formLogin().disable().build(); <= 구시대적 문법
		// 신세대 문법
		/*
		return http.formLogin(new Customizer<FormLoginConfigurer<HttpSecurity>>() {
			@Override
			public void customize(FormLoginConfigurer<HttpSecurity> t) {
				t.disable();
			}
		}).build();
		*/
		// return http.formLogin(t -> t.disable()).build();
		
		// Security에서 403을 반환해줌 => CSRF(Cross Site Request Forgery)가 튀어나옴
		// <img src="www.naver.com" />
		
		// 회원가입, 로그인은 => 누구나 할 수 있어야함
		// 회원정보수정, 탈퇴 => 로그인 한 사용자만 할 수 있어야함
		return http.formLogin(AbstractHttpConfigurer::disable)
				   .csrf(AbstractHttpConfigurer::disable)
				   .cors(Customizer.withDefaults())
				   .authorizeHttpRequests(requests -> {
					   // POST방식으로 /members라는 요청이 오면 권한 체크 안 하고 전부 허용
					   requests.requestMatchers(HttpMethod.POST, "/api/members", "/api/auth/login").permitAll();
					   // PATCH방식으로 /api/members 라는 요청이 오면 인증 확인
					   requests.requestMatchers(HttpMethod.PATCH, "/api/members", "/api/boards/**").authenticated();
					   requests.requestMatchers(HttpMethod.DELETE, "/api/members", "/api/boards/**").authenticated();
					   requests.requestMatchers(HttpMethod.POST, "/api/boards", "/api/comments").authenticated();
					   requests.requestMatchers(HttpMethod.GET, "/api/boards/**", "/api/comments", "/uploads/**").permitAll();
				   }).sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				   .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
				   .build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173", "http://localhost:5174"));
		configuration.setAllowedMethods(Arrays.asList("POST","PATCH", "DELETE", "GET", "PUT", "OPTIONS"));
		configuration.setAllowedHeaders(Arrays.asList("Authoriztion", "Content-Type"));
		configuration.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	
}
