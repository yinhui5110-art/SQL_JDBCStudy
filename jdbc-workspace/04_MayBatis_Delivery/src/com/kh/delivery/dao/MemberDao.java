package com.kh.delivery.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.dto.DeliMemberDto;

public class MemberDao {
	
	public int signUp(SqlSession session, DeliMemberDto deliMemberDto) {
		return session.insert("memberMapper.signUp", deliMemberDto);
	}
		
	public int checkId(SqlSession session, String memberId) {
		return session.selectOne("memberMapper.checkId",memberId);
		
	}
	
	public DeliMemberDto login(SqlSession session, DeliMemberDto deliMemberDto) {
		return session.selectOne("memberMapper.login",deliMemberDto);
	}
}


