package com.kh.semi.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	
	String store(MultipartFile file);
	
}
