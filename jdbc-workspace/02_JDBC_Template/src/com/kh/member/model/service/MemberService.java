package com.kh.member.model.service;

import java.sql.Connection;

import static com.kh.keeper.common.jdbcTemplate.*;//* => 전부라는 의미이다
import com.kh.member.exception.DuplicateMemberIdException;
import com.kh.member.exception.MemberIdToLargeException;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.dto.MemberDto;

public class MemberService {
	
	public boolean idCheck(String memberId) {
		Connection conn = getConnection();
		boolean result = new MemberDao().idCheck(conn, memberId);
		close(conn);
		return result;
		
		
	}
	public int signUp(MemberDto member) {
		// 길이체크 하기
		if(member.getMemberId().length() > 30 ) {
			throw new MemberIdToLargeException("아이디가 너무길어요");
		}
		// 모든 검사를 다 넘어갔다고 가정하고
		Connection conn = getConnection();
		
		
		MemberDao  md = new MemberDao();
		if(md.idCheck(conn,member.getMemberId())){
			throw new DuplicateMemberIdException("중복아이디입니다");
		}
		
		int result = md.signUp(conn,member);
		
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		
		return result;
		
		
		
		
	}
	

}
