package com.green.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
   static {//이 블록만큼은 객체 생성하지 않고 바로 메모리로 올림
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   @Test
   public void testConnection() {
      try (Connection con = 
      DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
            "green", "1234")){
         log.info(con);
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
}