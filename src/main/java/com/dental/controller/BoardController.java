package com.dental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dental.service.ConsultService;
import com.dental.service.NoticeService;
import com.dental.vo.NoticeVO;

@Controller
public class BoardController {
	@Autowired
	NoticeService service;
	@Autowired
	ConsultService cService;
	
	@GetMapping("/notice")
	public String getNotice(
		@RequestParam @Nullable Integer offset,
		@RequestParam @Nullable String keyword,		  
		@RequestParam @Nullable String type,			 
		Model model) {	
		
		 if(offset == null) offset = 0; 
		 if(keyword == null) keyword ="%%"; 
		 else
		 keyword="%"+keyword+"%"; 
		 if(type==null) type="title";
		 
		List<NoticeVO> list = service.getPostList(offset,19,keyword,type);
		
		model.addAttribute("list",list);
		model.addAttribute("board_seq",19);
		
		return "/notice/board";
	}
	
	 @GetMapping("/notice/write")
	    public String getNewNotice(){
	        return "/notice/write";
	   }
	 
	 @GetMapping("/notice/detail")
	 public String getNoticeDetail(@RequestParam Integer no,Model model) {
		 NoticeVO data = service.getPostBySeq(no);
		 model.addAttribute("data",data);
	        
		 return "/notice/detail";
	 } 
	 
	 @GetMapping("/notice/modify")
	 public String getModifyNotice(@RequestParam Integer seq, Model model) {
		 NoticeVO vo = service.getPostBySeq(seq);
		 model.addAttribute("postInfo",vo);
		 return "/notice/modify";
	 }
}
