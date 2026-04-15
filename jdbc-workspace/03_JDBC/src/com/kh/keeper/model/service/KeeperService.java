package com.kh.keeper.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.kh.keeper.common.jdbcTemplate;
import com.kh.keeper.model.dao.KeeperDao;
import com.kh.keeper.model.dto.KeeperDto;
import com.kh.keeper.model.vo.Keeper;

/*
 * 비즈니스 로직 작성(의사결정코드)-> 데이터 가공, 중복체크, 연산처리, 암호화 등등
 *트랜잭션 관리 : 특징 될거면 다 돼야하고 안되는 거는 다 안돼야 한다
 *여러 DAO 조합 
 * 예외 처리 및 예외 발생
 * 보안 및 권한 검사
 * 보통 Serviec 혹은 VO 클래스에서 작업한다
 */

public class KeeperService {
	
	/*
	 * Service :  Connection을 생성해서 DAO로 전달 +
	 * 				만약 SQL문을 수행하는데 필요한 값이 있다면 Controller로부터
	 * 				전달받아서 Connection과 같이 넘겨줄것 +
	 * 				DAO에서 DB작업이 끝나면 Service단에서 결과에 따른
	 * 				트랜잭션 처리도 진행
	 * 			    => DAO에는 순수하게 SQ문을 처리하는 부분만 남겨놓을 것
	 */
	
	public int insertKeeper(KeeperDto kd) {
		// DAO 호출 후 결과값 Controller로 반환해야한다
		Connection conn = jdbcTemplate.getConnection();
		
		int result = new KeeperDao().insertKeeper(conn,kd);
		
		if(result > 0) {
		   jdbcTemplate.commit(conn);
		}	
		
		jdbcTemplate.close(conn);
		
		return result;
	}
	
	public List<Keeper> selectKeeperList() {
		
		// 1. 커넥션 객체 받아오기
		Connection conn = jdbcTemplate.getConnection();
		
		// 2. 적절한 DAO단의 메소드 호출하기
		List<Keeper> keepers = new KeeperDao().selectKeeperList(conn);
		
		//3. 할일이 모두 끝나면 Connection 자원 반납한다
		jdbcTemplate.close(conn);
		
		//결과값 반환
		return keepers;
	}
	
	public int updateKeeper(Map<String, String> keeper) {
		
		Connection conn = jdbcTemplate.getConnection();
		
		int result = new KeeperDao().updateKeeper(conn, keeper);
		
		// 1. 변수명 메소드명 클래스명 똑바로쓰기
		// 2. 들여쓰기 잘하기
		// 3. 코드쓸때 이 코드가 무슨 코드인지 알기
		// 4. 코드는 몰라도 뭘해야할지는 생각하기
		// 5. 코드 많이 쳐보기
		// 5_1 -> 타자가 기본적으로 쳐져야 수업을 따라갈 수있음
		// 5_2 -> 직접코드를 쳐봐야 어떻게 돌아가는지 이해가 간다.
		if(result > 0) {
			jdbcTemplate.commit(conn);
		}
		jdbcTemplate.close(conn);
		
		return result;
	}
	
	public int deleteKeeper(String keeperId) {
		
		Connection conn = jdbcTemplate.getConnection();
		int result = new KeeperDao().deleteKeeper(conn,keeperId);
		
		if(result > 0) {
			jdbcTemplate.commit(conn);
			
		}
		jdbcTemplate.close(conn);
		
		return result;
		
	}
	
	
	
	

}
