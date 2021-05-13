package com.dental.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRegistVO {
	private Integer board_seq;
	private Integer user_seq;
	private String post_title;
	private String post_content;
}
