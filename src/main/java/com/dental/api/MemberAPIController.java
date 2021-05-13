package com.dental.api;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dental.service.MemberService;
import com.dental.utils.AESAlgorithm;
import com.dental.vo.LoginVO;
import com.dental.vo.MemberVO;
import com.dental.vo.SimpleMemberVO;

@RestController
public class MemberAPIController {
	@Autowired
	MemberService service;

	@PostMapping("/login")
	public Map<String, String> postLogin(@RequestBody LoginVO vo, HttpServletResponse response, HttpSession session) {
		Map<String, String> resultMap = new LinkedHashMap<String, String>();

		/*
		 * String pwd = vo.getDhm_pwd(); try { pwd = AESAlgorithm.Encrypt(pwd); } catch
		 * (Exception e) { e.printStackTrace(); } vo.setDhm_pwd(pwd);
		 */
		
		 if(service.MemberLogin(vo)) {
		 response.setStatus(HttpServletResponse.SC_ACCEPTED); 
		 resultMap.put("message", "로그인 되었습니다.");
		 
		 SimpleMemberVO memberInfo = service.SimpleMemberInfo(vo);		 
		 session.setAttribute("memberInfo",memberInfo); 
		 
		 } else {
		 response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		 resultMap.put("message","아이디 혹은 비밀번호가 틀렸습니다."); }	 

		return resultMap;
	}

	@PostMapping("/join")
	public Map<String, String> postJoin(@RequestBody MemberVO vo) {
		Map<String, String> resultMap = new LinkedHashMap<String, String>();

		service.MemberJoin(vo);

		resultMap.put("status", "success");
		resultMap.put("message", "가입되었습니다.");

		return resultMap;
	}

	@GetMapping("/member/id_check")
	public Map<String, String> getMemberIdCheck(@RequestParam String id) {
		Map<String, String> resultMap = new LinkedHashMap<String, String>();

		if (service.selectMemberCntById(id)) {
			resultMap.put("status", "ok");
			resultMap.put("message", "사용가능한 아이디입니다.");
		} else {
			resultMap.put("status", "failed");
			resultMap.put("message", "이미 등록된 아이디입니다.");
		}
		return resultMap;
	}
}
