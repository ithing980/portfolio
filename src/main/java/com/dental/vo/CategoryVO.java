package com.dental.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryVO {
	private Integer dhb_seq;
	private String dhb_name;
	private Integer dhb_parent_seq;
	private String dhb_url;
}
