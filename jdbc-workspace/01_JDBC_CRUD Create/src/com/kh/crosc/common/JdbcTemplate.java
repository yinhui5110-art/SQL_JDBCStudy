package com.kh.crosc.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTemplate {

	public static void JdbcTemplate() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		public static Connection getConnection() {
			
			try {
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE"
																,"C##HY"
																,"HY");
				
				conn.setAutoCommit(false);
				
				
					
						
						
			}
			
		}
		
		
		
		
		
		
	}

}
