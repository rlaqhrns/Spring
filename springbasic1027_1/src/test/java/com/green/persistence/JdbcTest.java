package com.green.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import static org.junit.Assert.fail;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@Log4j
public class JdbcTest { //오라클 db 연결 테스트 
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testConnection() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "green", "1234");
			log.info(conn);
					
			
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
