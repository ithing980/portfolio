package com.dental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dental.service.ConsultService;
import com.dental.vo.CommentReqVO;
import com.dental.vo.CommentVO;
import com.dental.vo.ConsultVO;
import com.dental.vo.NoticeVO;

@Controller
public class ConsultController {
	@Autowired
	ConsultService service;
	
	@GetMapping("/consult") 
	public String getConsult(
		@RequestParam @Nullable Integer offset,
		@RequestParam @Nullable String keyword,
		@RequestParam @Nullable String type,
		Model model) {
			if(offset == null) offset = 0;
	        if(keyword == null) keyword ="%%";
	        else keyword="%"+keyword+"%";
	        if(type==null) type="title";      
		List<ConsultVO> list = service.getPostList(offset,18);
		
		model.addAttribute("list",list);
		model.addAttribute("board_seq",18);
		return "/consult/board";		
	}
	
	 @GetMapping("/consult/write")
	    public String getNewConsult(){
	        return "/consult/write";
	   }
	 
	 @GetMapping("/consult/detail")
	 public String getConsultDetail(@RequestParam Integer no,Model model) {
		 ConsultVO data = service.getPostBySeq(no);
		 model.addAttribute("data",data);
		 
		 CommentReqVO vo = new CommentReqVO();
	        vo.setBoard_seq(no);
	        vo.setOffset(0);
	        List<CommentVO> comments = service.selectComment(vo);
	        model.addAttribute("comments", comments);
	        
		 return "/consult/detail";
	 }
	 
	 @GetMapping("/consult/modify")
	 public String getModifyConsult(@RequestParam Integer seq, Model model) {
		 ConsultVO vo = service.getPostBySeq(seq);
		 model.addAttribute("postInfo",vo);
		 return "/consult/modify";
	 }
	 
	 @GetMapping("/center") 
	 public String getCenter(
		@RequestParam @Nullable Integer offset,
		@RequestParam @Nullable String keyword,
		@RequestParam @Nullable String type,
		Model model) {
			if(offset == null) offset = 0;
	        if(keyword == null) keyword ="%%";
	        else keyword="%"+keyword+"%";
	        if(type==null) type="title";      
		List<ConsultVO> list = service.getPostList(offset,18);
		
		model.addAttribute("list",list);
		model.addAttribute("board_seq",18); {
		 return "/consult/board";
				} 
	 }
}
