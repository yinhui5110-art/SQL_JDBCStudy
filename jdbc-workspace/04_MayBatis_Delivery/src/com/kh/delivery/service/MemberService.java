package com.kh.delivery.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.common.DeliveryTemplate;
import com.kh.delivery.dao.MemberDao;
import com.kh.delivery.dto.DeliMemberDto;

public class MemberService {
	
	public void signUp(DeliMemberDto member) {
		SqlSession session = DeliveryTemplate.getSqlSession();
		
		new MemberDao().signUp(session, member);
		
	}

	public boolean idCheck(String memberId) {
		boolean result =  new MemberDao().idCheck(memberId);
		return result;
	}
	
	public LoginResponse login(DeliMemberDto member) {
		LoginResponse lr =  new MemberDao().login(member);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
