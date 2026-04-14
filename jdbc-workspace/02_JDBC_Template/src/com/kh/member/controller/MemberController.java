package com.kh.member.controller;

import com.kh.member.model.dto.MemberDto;
import com.kh.member.model.service.MemberService;

public class MemberController {
	
	public boolean idCheck(String memberId) {
		return new MemberService().idCheck(memberId);
	}          // boolean 타입의 값이다
	
	public int signUp(MemberDto member) {
		return new MemberService().signUp(member);
		
	}
	

}
