package com.kh.study.busan.model.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kh.study.busan.model.dao.ReviewMapper;
import com.kh.study.busan.model.dto.ReviewDto;
import com.kh.study.busan.model.dto.UpdateReviewDto;
import com.kh.study.exception.ResourceNotFoundException;

@Service
public class BusanService {
	
	@Autowired
	private ReviewMapper mapper;

	public String getRes(int page) {
		String url = "https://apis.data.go.kr/6260000/FoodService/getFoodKr?serviceKey=0683a518f80264d6ed4fb9185d5731cc8000a640948615a332afcb56c55176b9&numOfRows=6&resultType=JSON";
		url += "&pageNo=" + page;
		
		URI uri = null;
		try {
			uri = new URI(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String apiResponse = new RestTemplate().getForObject(uri, String.class);
		return apiResponse;
	}

	public String getDetail(int seq) {
		String url = "https://apis.data.go.kr/6260000/FoodService/getFoodKr?serviceKey=0683a518f80264d6ed4fb9185d5731cc8000a640948615a332afcb56c55176b9&numOfRows=1&resultType=JSON";
		url += "&UC_SEQ=" + seq;
		
		URI uri = null;
		try {
			uri = new URI(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String apiResponse = new RestTemplate().getForObject(uri, String.class);
		return apiResponse;
	}

	public void save(Long ucSeq, ReviewDto review) {
		review.setUcSeq(ucSeq);
		if(review.getRating() < 1 || 5 < review.getRating()) {
			// 예외 발생시키기
		}
		mapper.save(review);
	}

	public List<ReviewDto> findBySeq(Long ucSeq) {
		return mapper.findBySeq(ucSeq);
	}

	public void update(Long ucSeq, UpdateReviewDto urd) {
		urd.setUcSeq(ucSeq);
		int result = mapper.update(urd);
		if(result < 1) {
			throw new ResourceNotFoundException("리뷰가 없습니다.");
		}
	}

	public void delete(Long ucSeq, UpdateReviewDto urd) {
		urd.setUcSeq(ucSeq);
		mapper.delete(urd);
	}
	
	
	
}
