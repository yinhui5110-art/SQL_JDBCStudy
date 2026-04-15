package com.kh.crosc.model.dao;

import java.sql.Connection;
import java.sql.Statement;

import com.kh.crosc.model.dto.CrocsDto;



public class CrocsDao {
	
	public int save(CrocsDto crocsDto) {
		
		Connection conn = null;
		// 자바와 데이터베이스를 연결정보를 담는 객체(통로)
		//null -> 초기화
		// 초기화 안 하게 되면 컴파일 에러 발생
		Statement stmt = null;
		//SQL문 실행 후 결과를 받는 객체
		int result = 0; 
		// DML 수행 후 결과를 받기 위한 변수
		// DML : 데이터를 조작(추가,수정,삭제)하는 SQL명령어
		
		String sql = "INSERT "
					+ "INTO "
							+"CROCS "
					 + "VALUES "
					 		+ "("
					 		+ "'C' || SEQ_CROCS.NEXTVAL"
					 		+ ",'" + crocsDto.getCrocs_No() +"'"
					 		+ ",'" + crocsDto.getCrocs_Name() +"'"
					 		+	")";
		  System.out.println(sql);
		  
		return result;
		
	}

}
