package com.kh.task.user.model.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.task.exception.DuplicateUserIdException;
import com.kh.task.user.model.dao.UserMapper;
import com.kh.task.user.model.dto.UserDto;
import com.kh.task.user.model.vo.User;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

	private final UserMapper mapper;
	private final PasswordEncoder passwordEncoder;
	

	@Transactional
	public void signUp(@Valid UserDto user) {
		int count = mapper.countById(user.getUserId());
		if(count > 0) {
			throw new DuplicateUserIdException("이미 사용중인 아이디입니다.");
		}
		
		User userEntity = User.builder().userId(user.getUserId())
										.userPwd(passwordEncoder.encode(user.getUserPwd()))
										.userName(user.getUserName())
										.role("NOMAL")
										.build();
										
		// log.info("userEntity : {}", userEntity);
		mapper.signUp(userEntity);
	}
	
}
