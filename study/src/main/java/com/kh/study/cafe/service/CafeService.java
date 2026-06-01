package com.kh.study.cafe.service;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CafeService {
	private String key = "0683a518f80264d6ed4fb9185d5731cc8000a640948615a332afcb56c55176b9";

	public String getRes(int page) {
		String url = "https://api.odcloud.kr/api/15095876/v1/uddi:170b2205-6644-4de7-84dc-80b34a492281?serviceKey=" + key + "&perPage=6";
		url += "&page=" + page;
		
		URI uri = null;
		try {
			uri = new URI(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String apiResponse = new RestTemplate().getForObject(uri, String.class);
		return apiResponse;
	}
	
}
