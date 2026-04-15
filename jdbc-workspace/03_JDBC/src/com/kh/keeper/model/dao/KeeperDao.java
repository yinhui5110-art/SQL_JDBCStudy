package com.kh.keeper.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kh.keeper.common.jdbcTemplate;
import com.kh.keeper.model.dto.KeeperDto;
import com.kh.keeper.model.vo.Keeper;

// 중복코드가 많이 발생 할 수 있기 때문에
// 하나의 메소드는 하나의 작업만 해야한다

public class KeeperDao {
	/*
	 * DAO( Date access Object)
	 * 
	 * Database관련된 작업을 전문적으로 담당하는 객체
	 * 
	 * 하나의 메소드는 하나의 SQL문만 실행
	 * DB에 직접 접근해서 SQL문을 실행 후 결과 받아오기(JDBC)
	 * 
	 */
	/*
	 * JDBC용 객체
	 * - Connection : DB와 연결정보를 담는 객체
	 * - Statement :  SQL문 실행 응답 받아오는 객체 /완성된 SQL문을 
	 * - ResultSet : SELECT응답 결과 담겨있는 객체
	 * 
	 * - PreparedStatement : SQL문을 미리 준비하는 개념
	 * 	(Statementdml 자식   미완성된 SQL문을 미리 전달하고
	 * 						실행하기 전 값을 Bind해서 실행한다
	 * 						미완성된 SQL문에 사용자가 입력한 값이 들어갈 수 있도록
	 * 						공간확보를 해놓는다 == ?(placeholder)
	 * - Statement 와 PreparedStatement는 부모자식 관계
	 * 
	 * - 차이점
	 * 1) Statement는 완성된 SQL문, PreparedStatement는 미완성 SQL문
	 * 
	 * 2) 객체 생성
	 * Statement ==  커넥션객체.createStatement()
	 * PreparedStatement == 커넥션객체.prepareStatement(sql); <- 이것이 핵심
	 * 
	 * 3) SQL문 실행
	 * Statement ==  stmt.executeXXX(sql);
	 * PreparedStatement == pstmt.executeXXX();
	 * 
	 * 
	 * ? == placeholder에 실제값을 바인딩해준 뒤 실행한다.
	 * pstmt.setString()
	 * pstmt.setInt()
	 * 
	 */
	static {
		jdbcTemplate.registDriver();
	}
	public int insertKeeper(Connection conn, KeeperDto kd) {
		// 필요한 변수 선언
		
		// Connection conn =null;
		// Statement stmt =null;
		int result = 0;
		
		/*
		 * INSERT
		 * 	INTO
		 * 				KEEPER
		 * VALUES
		 * 		(
		 * 		 'K' || SEQ_KEEPER.NEXTVAL
		 * 		, '사용자가 입력한 사육사 이름'
		 * 		,
		 */
		//미완성된 SQL문이다
		String sql = """
						INSERT
						INTO
								KEEPER
						VALUES
									(
									'K' || SEQ_KEEPER.NEXTVAL
									, ?  
									, SYSDATE
									, ?
										)
							      """;
		//1번 ? == 사용자가 입력한 사육사 이름 2번 ? == 사용자가 입력한 사육사 구역
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			// pstmt.setXXX(?의 위치,실제값)
			pstmt.setString(1,  kd.getKeeperName());
			pstmt.setString(2,  kd.getZoneId());
			
			//pstmt.setString(홀도순번, 값)
			//=> '값' (양옆에 홑따옴표를 감싼 상태로 알아서 Bind(묶어준다))
			//pstmt.setInt(홀더순번,값)
			//=> 값 (알아서 잘들어간다)
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return result;
	}
	/*
	 * PreparedStatement가 Statement보다 좋은점
	 * 
	 * 1. 구문분석 및 컴파일 최적화
	 * 
	 * Statement는 매번 SQL문을 파싱하고 실행하지만
	 * PreparedStatement는 SQL쿼리를 최초 1회만 파싱하고 실행계획을 캐싱(메모리에 올림)
	 * 재사용적인 측면에서 훨씬 효율적이다
	 * 
	 * 2. DB서버에 대한 트래픽 감소
	 * 
	 * 쿼리자체는 한 번만 전송하고 이후에는 바인딩할 값만 전송하기 때문에
	 * 동일쿼리를 반복 실행할 때, 높은 트래픽이 몰리는 애플리케이션일 때 더욱 효율적이다.
	 * DB작업 -> 계획 세울 때 리소스를 많이 잡아먹는다
	 * 
	 * 
	 * SELECT
	 * 			EMAIL
	 * 
	 * 
	 * SQL Injection ->SQL을 악의적으로 주입
	 * 
	 * PreparedStatement는 SQL 인젝션 방지가 되기 때문에 => 보안적인 측면에서도 좋다
	 * 
	 * 
	 */
	
	public List<Keeper> selectKeeperList(Connection conn){
		List<Keeper>keepers =  new ArrayList();//반환할 리스트를 만든다
		String sql = """
						SELECT
								KEEPER_ID
								,KEEPER_NAME
								,HIRE_DATE
								,ZONE_ID
						FROM
								KEEPER
						ORDER
						  BY
						  		KEEPER_ID DESC
						""";
		// 내림차순 올림차순 바꿀때 마다 컴파일된 클래스파일을 메모리에 올라가있는 상태에서 
		// 다시 메모리에 올라가면 그때 변경된 내용이 나온다
		//
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rset = pstmt.executeQuery()) {
				// ResultSet이 왔는데 조회 결과가 있을 수도 있음/ 없을 수도 있다
				while(rset.next()) {
					Keeper keeper = new Keeper(rset.getString("KEEPER_ID")
												,rset.getString("KEEPER_NAME")
												,rset.getDate("HIRE_DATE")
												,rset.getString("ZONE_ID"));
					keepers.add(keeper);
				}
				}catch(SQLException e) {
					e.printStackTrace();
				}
					return keepers;
		
	}
	

	public int updateKeeper(Connection conn, Map<String, String >keeper) {
		int result = 0; 
		String sql = """
						UPDATE
						 			KEEPER
						 	SET
						 			KEEPER_NAME = ?
						 		  , HIRE_DATE = ?
						 		  , ZONE_ID = ?
						 	WHERE
						 			KEEPER_ID = ?
				        """;
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql);){
			
			pstmt.setString(1, keeper.get("keeperName"));
			pstmt.setString(2, keeper.get("hireDate"));
			pstmt.setString(3, keeper.get("zoneId"));
			pstmt.setString(4, keeper.get("keeperId"));
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public int deleteKeeper(Connection conn, String keeperId) {
		int result = 0;
		String sql = """
							DELETE
							FROM
							    KEEPER
							 WHERE
							    	KEEPER_ID = ?
				""";
		try(PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, keeperId);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
