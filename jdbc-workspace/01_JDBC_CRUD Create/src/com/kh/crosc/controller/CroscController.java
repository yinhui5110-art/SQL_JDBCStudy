package com.kh.crosc.controller;

import com.kh.crosc.model.dto.CrocsDto;
import com.kh.crosc.model.service.CrocsService;

public class CroscController {
	/*
	//3)
	private CrocsService crocsService = new CrocsService();
	
	//1)
	public int save(String crocs_No,String crocs_Name,String price,String size) {
		//2)
		CrocsDto crocsDto = new CrocsDto(crocs_No,crocs_Name,price,size);
		//4)
		return crocsService.save(crocsDto);
	}
	*/
	private void insertCrosc(CrocsDto cd) {
		new CrocsService().insertCrosc(cd);
	}
	
	
	
	
}
