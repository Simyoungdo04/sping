package com.kh.study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
	
	@Bean
	public StudyBean study() {
		return new StudyBean();
	}
	
	@Bean
	public StudyBoot studyBoot() {
		return new StudyBoot();
	}
	
	/*
	 * @Configuration
	 * 
	 * 스프링에서 설정 클래스를 정의할 때 사용
	 * 하나 이상의 @Bean이 달린 메소드를 포함해서 스프링 컨테이너에 빈으로 등록하는 역할
	 * 
	 * @Bean
	 * 
	 * @Configuration클래스 내부에서 메소드에 달려서 스프링 빈을 생성함
	 * 메소드의 반환값이 스프링컨테이너에 빈으로 등록됨
	 * 
	 * XML로 설정하는 것보다 빠른 시점에 오류 발견이 가능
	 * 코드 기반이기 때문에 자동완성이 가능
	 * 설정 클래스 안에서 빈의 생성과정을 명확하게 정의할 수 있음
	 */
}
