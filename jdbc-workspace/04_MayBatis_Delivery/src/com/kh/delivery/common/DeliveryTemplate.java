package com.kh.delivery.common;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DeliveryTemplate {

	public static SqlSession getSession() {
		
		SqlSession session = null;
		String resource = "mybatis-config.xml";
		;
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			session = new SqlSessionFactoryBuilder().build(inputStream).openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}
	
	
	
	
	
	
}
	
	
		
		
		
		
	
	
