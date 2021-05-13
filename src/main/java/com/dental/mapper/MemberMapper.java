package com.dental.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.dental.vo.LoginVO;
import com.dental.vo.MemberVO;
import com.dental.vo.SimpleMemberVO;

@Mapper
public interface MemberMapper {
	public Integer MemberLogin(LoginVO vo);
	public SimpleMemberVO SimpleMemeberInfo(LoginVO vo);
	public void MemberJoin(MemberVO vo);
	public Integer selectMemberCntById(String id);
}
