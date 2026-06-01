package com.kh.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyApplication {

	// 애플리케이션을 구동 -> @SpringBootApplication애노테이션이 부튼 클래스의 main메소들르 호출
	
	// @EnableAutoConfiguration => ComponentScan으로 컴포넌트 쫙 스캔 -> 모든 자동구성이 활성화가 끝나면 애플리케이션을 실행
	// AutoConfiguration(자동 구성)
	// 스프링부트의 핵심 기능 -> 애플리케이션의 클래스 패스에 존재하는 라이브러리 및 설정을 기반으로 Bean 을 싸그리몽땅 자동 구성해줌
	// 개발자가 설정 하나도 안 하고 개발을 시작할 수 있음
	
	
	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
	}

}
