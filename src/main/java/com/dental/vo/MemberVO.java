package com.dental.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	private Integer dhm_seq;
	private String dhm_id;
	private String dhm_pwd;
	private String dhm_name;
	private String dhm_email;
	private String dhm_phone;
	private Integer dhm_collect_agree;
	private Integer dhm_terms;
	private Integer dhm_type;
}
