package com.kh.aimal.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.aimal.common.Template;
import com.kh.aimal.model.dao.KeeperDao;
import com.kh.aimal.model.dto.KeeperDto;

public class KeeperService {
	
	// 시간!
	// 쿼리 실행시간 0.1ms
	// + 
	// 네트워크 왕복(Round Trip) / 자바서버 / DB서버
	//                                  ->
	//									<-
	//								0.5 ~ 2ms -> 수십ms
	// SQL파싱 + 실행계획 수립 -> DB가 SQL받아서 분석하는 비용
	// +
	// 커넥션 점유 -> 쿼리가 전부 끝날때까지 커넥션을 계속 붙잡고있어야함
	
	// 시나리오 : 사육사가 100명정도 있다고 하면
	// 한번에 사육사 + 사육사 담당 동물목록 조회한다고 하면
	//DB커넥션 풀 20개 정도 될텐데 못해도 쿼리가 500~600개 정도 날아 갈것이다
	//여기서 문제는 사용자가 20명이라고하면 21명 사용자는 앞에 사용자가 다 사용할때 까지 기다려야하는 상황이 생긴다
	//
	
	public List<KeeperDto> selectKeeperAndAnimals(){
		SqlSession session = Template.getSqlSession();
		
		// 쿼리 1번 - 사육사 전체조회
		/*
		List<KeeperDto> keepers = new KeeperDao().selectKeeperList(session);
		
		// 쿼리 N번 - 각 사육사마다 동물 목록 조회
		for(KeeperDto keeper : keepers) {
			List<AnimalDto> animals =
					new KeeperDao().selectAnimalList(session, keeper.getKeeperId());
				keeper.setAnimals(animals);
		
		}
		*/
		List<KeeperDto> keepers = new KeeperDao().findKeeperAndAnimals(session);
		session.close();
		
		return keepers;
			
	
	}
	
	public List<KeeperDto> selectKeeperByCondition(Map<String,String> arguments){
		SqlSession session = Template.getSqlSession();
		
		List<KeeperDto> keepers = new KeeperDao().selectKeeperByCondition(session,arguments);
		
		session.close();
		return keepers;
		

		
	
	}
	
	
	
	
	
	
	
	
	

}
