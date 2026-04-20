package com.kh.delivery.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DeliveryTemplate {
	
	public static SqlSession getSqlSession() {
		SqlSession sqlSession = null;
		
		String config ="mybatis-config2.xml";
		
		try {
			InputStream stream = Resources.getResourceAsStream(config);
		
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	
	
	   return sqlSession;
	}
}
