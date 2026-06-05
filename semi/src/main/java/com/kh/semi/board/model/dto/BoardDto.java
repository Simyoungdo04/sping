package com.kh.semi.board.model.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
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
public class BoardDto {
	private Long boardNo;
	@NotBlank
	private String boardTitle;
	@NotBlank
	private String boardContent;
	private String boardWriter;
	private String fileUrl;
	private Date createDate;
	private String status;
}
