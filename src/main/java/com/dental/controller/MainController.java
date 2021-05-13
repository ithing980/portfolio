package com.dental.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dental.service.NoticeService;
import com.dental.vo.NoticeVO;

@Controller
public class MainController {
	@Autowired
	NoticeService service;
	
	@GetMapping("/login")
	public String getLogin() {
		return "/member/login";
	}
	
	@GetMapping("/logout")
	public String getLogout(HttpSession session) {
		session.setAttribute("memberInfo",null);
		session.invalidate();		
		return "redirect:/";
	}
	
	@GetMapping("/join")
	public String getJoin() {
		return "/member/join";
	}
	
	
	  @GetMapping("/") public String GetMain(Model model) { 
			/*
			 * List<NoticeVO> noticeList = service.getPostList(0,19,"%%",null);
			 * List<NoticeVO> newNoticeList = new ArrayList<NoticeVO>();
			 * 
			 * int limit = 0; if(noticeList.size() < 5) limit = noticeList.size(); else
			 * limit = 5; for(int i=0; i < limit; i++) {
			 * newNoticeList.add(noticeList.get(i)); } model.addAttribute("noticeList",
			 * newNoticeList);
			 */
		  return "/main"; 
	  }
	 
	
	 @GetMapping("/directions")
	 public String getDirections() {
		 return "/directions/directions";
	 }
	 
	 @GetMapping("/information")
	 public String getInformation() {
		 return "/information/information";
	 }
	 
	 @GetMapping("/implant")
	 public String getImplant() {
		 return "/implant/implant";
	 }
	 
	 @GetMapping("/treatment")
	 public String getTreatment() {
		 return "/treatment/treatment";
	 }
	 
	 @GetMapping("/perio")
	 public String getperio() {
		 return "/perio/perio";
	 }
	 
	 @GetMapping("/dental")
	 public String getDental() {
		 return "/main";
	 }
}