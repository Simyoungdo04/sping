package com.kh.semi.comment.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentDto {
	private Long commentNo;
	private String commentWriter;
	private Long refBoardNo;
	private String commentContent;
	private Date createDate;
	private String status;
}
