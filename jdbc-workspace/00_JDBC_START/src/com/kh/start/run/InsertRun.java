package com.kh.start.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertRun {

	public static void main(String[] args) {
		// JDBC
		/*
		 * JAVA를 사용하지 않았을때 zone테이블에 한 행 인서트(행추가)하러면 어떤 절차가 필요했지? 먼저 생각해보기
		 * 1. 컴퓨터 on
		 * 2. 디비버를 실행한다(오라클서버에 클라이언트 요청할 수 있는 프로그램)
		 * 		(java에서는 메인메소드 역할)
		 * 3. 접속하기(콘센트) 누름
		 * 		(
		 * 4. Oracle선택하기
		 * 5. IP주소, PORT번호, 사용자이름, 비밀번호가지고 연결
		 * 6. 새 편집기 만들기
		 * 7. INSERT문 작성 => INSERT INTO ZONE VALUES('값','값','값')
		 * 8. SQL문을 실행
		 * 9. UpdatedRows :
		 * 10. commit 
		 * 
		 */
		// 0) 필요한 변수 세팅
		Connection conn = null;
		Statement stmt = null;
		int result = 0; //결과를 미리 받아 놓을 정수타입이 필요하다
		
		//사용자가 입력한 값을 DBMS로 보내서 => ZONE테이블에 INSERT 작업하기
		Scanner sc = new Scanner(System.in);
		System.out.println("ZONE_ID를 입력해주세요 > ");
		String zoneId = sc.nextLine();
		System.out.println("ZONE_NAME을 입력해주세요 >");
		String zoneName = sc.nextLine();
		System.out.println("ZONE_TYPE을 입력해주세요 >");
		String zoneType = sc.nextLine();
		String sql = "INSERT INTO ZONE VALUES('50', '테스트', '테스트')";
		sql = "INSERT INTO ZONE VALUES('"+ zoneId + "',"
										+"'"+ zoneName + "',"
										+"'"+ zoneType + "')";
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ZONE VALUES(");
		sb.append("+ zoneId + ,");
		sb.append("+ zoneName + ,");
		sb.append("+ zoneType + ");
		sql = sb.toString();
		
		// 나는 오라클 DBMS에다가 작업할거다!
		
		try {
			// 리플렉션을 사용해서 동적으로 클래스 로드
			
			// 1) JDBC Driver 등록-> ORALCE -> ojdbc.jar
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver등록 성공~!");
			
			// 2) DB서버랑 연결한다(IP주소, PORT번호, 사용자이름, 비밀번호)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "C##HY", "HY");
							//오라클회사에서 정했기 때문에 외워야한다 ★URL->jdbc:oracle:thin:@IP주소:PORT번호
			System.out.println("DB연결 성공!");
			
			// 학습을 위해 오토커밋 끄기
			conn.setAutoCommit(false); //Auto setter Commit 필드
			
			// 3) 새 SQL편집기 열기
			stmt = conn.createStatement(); // Statement객체 생성하기/ 새편집기 생성한 것이다
			System.out.println("Statement 객체 생성!");
			
			//4) SQL문 실행
			//executeUpdate(DML문) :int
			result = stmt.executeUpdate(sql);
			System.out.println("SQL문 실행 성공~!");
			
			if(result >0 ) {
				conn.commit();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("1.ojdbc.jar파일을 추가하지 않음");
			System.out.println("2. oracle.jdbc.driver.OracleDriver 오타확인");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("URL을 잘못 적었을경우");
			System.out.println("username/password; logon denied 오타확인");
			System.out.println("SQLSyntaxErrorException :SQL문 오타 확인");
			System.out.println("NULLPointerException ->JDBC객체들 확인하기");
			
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		

	}

}
