package com.kh.aimal.controller;

import java.util.List;
import java.util.Map;

import com.kh.aimal.model.dto.KeeperDto;
import com.kh.aimal.model.service.KeeperService;

public class KeeperController {
	public List<KeeperDto> selectKeeperAndAnimals(){
		return new KeeperService().selectKeeperAndAnimals();
		
	}
	
	public List<KeeperDto> selectKeeperByCondition(Map<String,String>arguments){
		return new KeeperService().selectKeeperByCondition(arguments);
		
	}

}
