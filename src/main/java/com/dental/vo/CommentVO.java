package com.dental.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter 
@Getter
public class CommentVO {
	private Integer dhci_seq;
	private Integer dhci_dhc_seq;
	private Integer dhci_dhm_seq;
	private Integer dhci_status;
	private String dhci_content;
	private Date dhci_reg_date;
	private String dhm_name;
}
