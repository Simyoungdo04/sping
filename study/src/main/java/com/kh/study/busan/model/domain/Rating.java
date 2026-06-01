package com.kh.study.busan.model.domain;

public class Rating {
	private int rating;
	
	public Rating(int rating) {
		checkRating(rating);
		this.rating = rating;
	}
	
	private void checkRating(int rating) {
		if(rating > 1 || 5 < rating) {
			throw new RuntimeException("올바르지 않은 별점");
		}
	}
	
	public int getRating() {
		return rating;
	}
}
