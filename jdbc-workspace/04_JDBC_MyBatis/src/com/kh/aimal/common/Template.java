package com.kh.aimal.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	// Connection객체 생성~~ 하지않고
	// 싱글톤 패턴(Singleton Pattern)은 클래스의 인스턴스가 애플리케이션 내에서 
	// 오직 하나만 생성되도록 보장하고, 
	// 어디서든 그 인스턴스에 접근할 수 있도록 하는 디자인 패턴이다.
	//Connection대신할 SQLSession객체를 만드는 메소드를 구현할 것!
	
	public static SqlSession getSqlSession() {
		SqlSession sqlSession = null;
		
		// mybatis-config.xml파일에 작성란 environment요소의 내용을 읽어와서
		// 해당 DB와 연결된 SqlSession객체 생성
		String config = "mybatis-config.xml";
		try {
			InputStream stream = Resources.getResourceAsStream(config);
			// 1단계 : SqlSessionFacntoryBuilder 만들기
			//만드는 법 : 기본생성자를 호출한다.
			//new SqlSessionFactoryBuilder();
			// 2단계 : SqlSessionFactory 만들기
			// 만드는 법 : Builder를 참조해서 메소드를 호출한다.
			// .build(접속 내용을 담은 파일을 읽어온 입력스트림);
			//new SqlSessionFactoryBuilder().build(stream);
			// 3단계 :  SqlSesseion 만들기
			// 만드는 법 : Factory를 참조해서 메소드를 호출한다.
			// .openSession();
			sqlSession =  new SqlSessionFactoryBuilder().build(stream).openSession();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSession;
	}

}
