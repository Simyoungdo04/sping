package com.kh.semi.api.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {
	private int code;
	private String message;
	private T data;
	/*
	 * 제네릭이 오브젝트보다 좋은 점
	 * 
	 * 타입 안정성 => Object 받으면 꺼내 쓸때 캐스팅을 강제로 해야함, 캐스팅이 틀려도 컴파일러가 못잡음
	 * IDE 자동완성 / 가독성 => ResponseEntity<ApiResponse<LoginResponse>>
	 */
	// 200 성공응답
	public static <T> ApiResponse<T> success(T data) {
		return new ApiResponse<T>(200, "요청에 성공했습니다.", data);
	}
	
	// 201 성공응답
	public static <T> ApiResponse<T> created(T data) {
		return new ApiResponse<T>(201, "요청에 성공했습니다.", data);
	}
	
	public static <T> ApiResponse<T> created(String message, T data) {
		return new ApiResponse<T>(201, message, data);
	}
	
	// 204 성공응답
	public static <T> ApiResponse<T> noContent(T data) {
		return new ApiResponse<T>(204, "요청에 성공했습니다.", data);
	}
	
	/*
	 * static Factory pattern
	 * 
	 * 1. 메소드의 이름으로 역할을 의미할 수 있음
	 * 2. 객체가 필요할 때 마다 새로 생성하는 것이 아니라 재활용할 수 있음
	 * 3. 객체 생성한 곳에서 통제 할 수 있음
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
