package com.kh.rasp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.rasp.model.dto.SensorDto;
import com.kh.rasp.model.entity.Sensor;
import com.kh.rasp.model.service.SensorService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/api/sensor")
@RequiredArgsConstructor
public class SensorController {
	
	private final SensorService sensorService;
	
	@PostMapping
	public ResponseEntity<?> receive(@RequestBody SensorDto dto){
		log.info("데이터 수신 : {}", dto);
		sensorService.save(dto);
		return ResponseEntity.ok("빠이");
	}
	
	@GetMapping
	public ResponseEntity<List<Sensor>> findAll() {
		return ResponseEntity.ok(sensorService.findAll());
	}
	
	/*
	 * 				JPA             |			MyBatis
	 * ------------------------------------------------------------
	 * SQL  | 	안 씀, 자동 생성       |	 	  	직접 생성
	 * 관점  |	객체를 저장 / 조회		| 			SQL을 실행
	 * 코드  |  		적음				| 			많음
	 * 제어력	|	자동이라 세밀 제어X		| 			SQL문 완전 제어
	 * 		|	튜닝이 어렵다			|			복잡 쿼리 튜닝 유리
	 * 러닝	| 	개발(영속성, 매핑)		|			SQL만 알면 직관적
	 * 커브  |	이해 필요				|
	 * -------------------------------------------------------------
	 * 			신규, 스타트업			|			SI, 레거시
	 * 			기술 회사				|
	 * 
	 * JPA의 save는 INSERT/UPDATE를 알아서 판단함
	 * 인자로 Entity를 전달
	 * Entity에 id가 없으면 새 객체로 판단 INSERT문을 수행
	 * Entity에 id값이 있다 기존 객체로 판단 UPDATE문을 수행
	 * 
	 * JPA : 자바 객체를 컬렉션에 넣고 빼드시 DB를 다루자 => ORM
	 * MyBatis : 내가 쓴 SQL을 실행하는 도구 		 => SQL Mapper
	 */
	
	
	
}
