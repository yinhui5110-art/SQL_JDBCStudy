package com.kh.delivery.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.common.DeliveryTemplate;
import com.kh.delivery.dao.MemberDao;
import com.kh.delivery.dto.DeliMemberDto;

public class MemberService {
	
	public int signUp(DeliMemberDto deliMemberDto) {
		SqlSession session = DeliveryTemplate.getSqlSession();
		
		int result = new MemberDao().signUp(session, deliMemberDto);
		if(result >0) {
			session.commit();
		}
		session.close();
		return result;
	}

	public boolean checkId(String memberId) {
		SqlSession session =DeliveryTemplate.getSqlSesison();
		boolean result =  new MemberDao().checkId(session,memberId);
		session.close();
		return result;
	}
	
	public DeliMemberDto login(DeliMemberDto deliMemberDto) {
		SqlSession session = DeliveryTemplate.getSqlSession();
		DeliMemberDto deliMemberDto = new DeliMemberDto().login(session,deliMemberDto);
		session.close();
		return deliMemberDto;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
