package com.kh.study.busan.model.dto;

import java.sql.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReviewDto {
	/*
	 * @Size(min=,max=) 문자열 길이 체크 / 컬렉션 크기 범위
	 * @Pattern(regexp=) 정규표현식 => @Pattern(regexp="^010-\\d{4}-\\d{4}$")
	 * @Email 이메일 형식 
	 * @Positive 양수
	 * @Negative 음수
	 */
	private Long ucSeq;
//	@NotNull => Null 못들어온다 / "" 들어올 수 있다 / "	" 들어올수 있다=> 모든 타입에 사용이 가능
//	@NotEmpty => Null못들어온다 / "" 들어올 수 있다 / "	" 들어올 수 없다 => String, Collection, Map, 배열
//	@NotBlank <=> Null 못들어온다 / "" 들어올 수 없다 / "	" 들어올 수 없다 => String전용 
	@NotBlank(message="내용을 적어야 합니다.")
	private String content;
	@NotNull(message="별점은 필수로 작성해야합니다.")
	@Min(value = 1, message="별점은 1점 이상이어야 합니다.")
	@Max(value = 5, message="별점은 5점 이하여야 합니다.")
	private Integer rating;
	private Date createDate;
	public ReviewDto() {
		super();
	}
	public ReviewDto(Long ucSeq, String content, Integer rating, Date createDate) {
		super();
		this.ucSeq = ucSeq;
		this.content = content;
		this.rating = rating;
		this.createDate = createDate;
	}
	public Long getUcSeq() {
		return ucSeq;
	}
	public void setUcSeq(Long ucSeq) {
		this.ucSeq = ucSeq;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "ReviewDto [ucSeq=" + ucSeq + ", content=" + content + ", rating=" + rating + ", createDate="
				+ createDate + "]";
	}
}
