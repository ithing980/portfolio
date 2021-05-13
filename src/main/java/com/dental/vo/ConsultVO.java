package com.dental.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultVO {
	private Integer dhc_seq;
	private String dhc_title;
	private String dhc_content;
	private Date dhc_reg_date;
	private Date dhc_mod_date;
	private String dhc_comment;
	private Integer dhc_owner;
	private Integer dhc_board_seq;
	private Integer no;
	private String dhm_name;
}
