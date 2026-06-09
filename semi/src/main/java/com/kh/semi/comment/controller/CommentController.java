package com.kh.semi.comment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.semi.api.model.vo.ApiResponse;
import com.kh.semi.auth.model.vo.CustomUserDetails;
import com.kh.semi.comment.model.dto.CommentDto;
import com.kh.semi.comment.model.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {
	
	private final CommentService commentService;
	
	// 댓글작성
	@PostMapping
	public ResponseEntity<ApiResponse<Void>> save(@RequestBody CommentDto comment, 
								  @AuthenticationPrincipal CustomUserDetails user) {
		commentService.save(comment, user);
		// ApiResponse<Void> ar = new ApiResponse<Void>(201, "댓글작성 성공", null);
		return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.created(null));
	}
	
	@GetMapping
	public ResponseEntity<ApiResponse<List<CommentDto>>> findAll(@RequestParam(name="boardNo") Long boardNo) {
		List<CommentDto> comments = commentService.findAll(boardNo);
		// ApiResponse<List<CommentDto>> ar = new ApiResponse(200, "댓글조회 성공", comments);
		return ResponseEntity.ok(ApiResponse.success(comments));
	}
	
}
