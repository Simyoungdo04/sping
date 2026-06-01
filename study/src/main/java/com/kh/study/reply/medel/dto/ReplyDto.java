package com.kh.study.reply.medel.dto;

public class ReplyDto {
	private Long replyNo;
	private String replyContent;
	private String replyWriter;
	public ReplyDto(Long replyNo, String replyContent, String replyWriter) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.replyWriter = replyWriter;
	}
	public ReplyDto() {
		super();
	}
	public Long getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(Long replyNo) {
		this.replyNo = replyNo;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyWriter() {
		return replyWriter;
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	@Override
	public String toString() {
		return "ReplyDto [replyNo=" + replyNo + ", replyContent=" + replyContent + ", replyWriter=" + replyWriter + "]";
	}
}
