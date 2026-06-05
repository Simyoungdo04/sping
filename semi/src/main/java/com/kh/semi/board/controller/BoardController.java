package com.kh.semi.board.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.semi.auth.model.vo.CustomUserDetails;
import com.kh.semi.board.model.dto.BoardDto;
import com.kh.semi.board.model.service.BoardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	// 게시글 작성 + 파일첨부
	@PostMapping
	public ResponseEntity<Void> save(@Valid BoardDto board,
									 @RequestParam(name="file", required=false) MultipartFile file,
									 @AuthenticationPrincipal CustomUserDetails user) {
		// log.info("게시글 정보 : {} / 파일 정보 : {} / 유저 정보 : {}", board, file.getOriginalFilename(), user.getUsername());
		boardService.save(board, file, user);
		return ResponseEntity.status(201).build();
	}
	
	@GetMapping
	public ResponseEntity<List<BoardDto>> findAll(@RequestParam(name="page", defaultValue="0") int page){
		List<BoardDto> boards = boardService.findAll(page);
		return ResponseEntity.ok(boards);
	}
	
	@GetMapping("/{boardNo}")
	public ResponseEntity<BoardDto> findByBoardNo(@PathVariable(name="boardNo") Long boardNo) {
		return ResponseEntity.ok(boardService.findByBoardNo(boardNo));
	}
	
	@PatchMapping("/{boardNo}")
	public ResponseEntity<Void> update(@Valid BoardDto board, 
									   @RequestParam(name="file", required=false) MultipartFile file,
									   @AuthenticationPrincipal CustomUserDetails user,
									   @PathVariable(name="boardNo") Long boardNo) {
		boardService.update(board, file, user, boardNo);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{boardNo}")
	public ResponseEntity<Void> delete(@AuthenticationPrincipal CustomUserDetails user,
									   @PathVariable(name="boardNo") Long boardNo) {
		boardService.deleteByBoardNo(user, boardNo);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
