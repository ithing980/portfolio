package com.dental.vo;

import lombok.Getter;
import lombok.Setter;


public class CommentReqVO {
	private Integer offset;
    private Integer board_seq;
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(Integer board_seq) {
		this.board_seq = board_seq;
	}
    
}
