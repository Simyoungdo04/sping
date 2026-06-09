package com.kh.semi.comment.model.vo;

import java.sql.Date;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Comment {
	private Long commentNo;
	private String commentWriter;
	private Long refBoardNo;
	private String commentContent;
	private Date createDate;
	private String status;
}
