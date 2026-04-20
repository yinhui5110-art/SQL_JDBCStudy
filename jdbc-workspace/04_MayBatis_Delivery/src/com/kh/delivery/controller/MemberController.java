package com.kh.delivery.controller;

import com.kh.delivery.dto.DeliMemberDto;
import com.kh.delivery.service.MemberService;

public class MemberController {
	
	public void signUp (DeliMemberDto member) {
		new MemberService().signUp(member);
		
		
	}
	
	public boolean idCheck(String memberId) {
		return new MemberService().idCheck(memberId);
	}

	public LoginResponse login(DeliMemberDto member) {
		new MemberService().login(member);
	}
	
	
	
	
	
	
	
}
