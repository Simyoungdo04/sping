package com.kh.semi.board.model.vo;

import java.sql.Date;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Board {
	private Long boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private String fileUrl;
	private Date createDate;
	private String status;
}
