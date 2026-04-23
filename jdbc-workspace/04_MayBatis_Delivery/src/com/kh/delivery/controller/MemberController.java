package com.kh.delivery.controller;


import com.kh.delivery.dto.DeliMemberDto;
import com.kh.delivery.service.MemberService;

public class MemberController {
	
	public int signUp(DeliMemberDto deliMemberDto) {
		new MemberService().signUp(deliMemberDto);
		
		
	}
	
	public boolean checkId(String memberId) {
		return new MemberService().checkId(memberId);
	}

	public DeliMemberDto login(DeliMemberDto deliMemberDto) {
		return new MemberService().login(deliMemberDto);
	}
	
	
	
	
	
	
	
}
