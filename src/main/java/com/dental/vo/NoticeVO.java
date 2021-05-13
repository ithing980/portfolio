package com.dental.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private Integer dhn_seq;
	private String dhn_title;
	private String dhn_content;
	private Date dhn_reg_date;
	private Date dhn_mod_date;
	private Integer dhn_count;
	private Integer dhn_owner;
	private Integer dhn_board_seq;
	private Integer no;
}
