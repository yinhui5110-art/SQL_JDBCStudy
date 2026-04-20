package com.kh.start.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertRun {

	public static void main(String[] args) {

		//Crocs테이블에 한 행 인서트해보기
		
		//필요한 변수 세팅하기
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("CROCS_NO를 입력해 주세요 > ");
		String crocsNo = sc.nextLine();
		System.out.println("CROCS_NAME를 입력해 주세요 > ");
		String crocsName = sc.nextLine();
		System.out.println("PRICE을 입력해주세요 > ");
		String price = sc.nextLine();
		System.out.println("SIZE를 입력해주세요 > ");
		String size = sc.nextLine();
		String sql = "INSERT INTO CROCS VALUES('100','80','테스트' , '테스트')" ;       
		sql = "INSERT INTO CROCS VALUES('" + crocsNo + "'," 
										   + "'" + crocsName + "',"
										   + "'" + price +"'"
										   +"'" + size + "')";
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO CROSC VALUES(");
		sb.append(" + corcsNo + , ");
		sb.append("+ corcsName + ,");
		sb.append("+ price + ,");
		sb.append("+ size + ");
		sql = sb.toString();
		
		try {
			// 1) jdbc driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver등록 성공했습니다~!");
		
			// 2) DB서버랑 연결한다(IP주소,port번호, 사용자이름, 비번)
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","C##HY","HY");
			System.out.println("DB연결 성공~!!");
			
			conn.setAutoCommit(false);
			
			// 3) 새 SQL편집기 열기
			stmt = conn.createStatement();
			System.out.println("Statement 객체 생성!!");
			
			
			// 4) SQL문 실행
			result = stmt.executeUpdate(sql);
			System.out.println("SQL문 실행 성공~!");
			
			if(result > 0) {
				conn.commit();
			}
			
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
