package com.dental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dental.mapper.MemberMapper;
import com.dental.vo.LoginVO;
import com.dental.vo.MemberVO;
import com.dental.vo.SimpleMemberVO;
import com.dental.utils.AESAlgorithm;

@Service
public class MemberService {
	@Autowired
	MemberMapper mapper;
	
	public boolean MemberLogin(LoginVO vo) {
		return mapper.MemberLogin(vo)==1;
	}
	
	public SimpleMemberVO SimpleMemberInfo(LoginVO vo) {
		return mapper.SimpleMemeberInfo(vo);
	}
	
	public void MemberJoin(MemberVO vo) {
		/*
		 * String password = vo.getDhm_pwd(); try { password =
		 * AESAlgorithm.Encrypt(password); } catch(Exception e) { e.printStackTrace(); }
		 */
		mapper.MemberJoin(vo);
	}
	
		public boolean selectMemberCntById(String id) {
		
		return !(mapper.selectMemberCntById(id) > 0); 
	}

} 
