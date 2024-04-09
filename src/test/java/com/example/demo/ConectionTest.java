package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

public class ConectionTest {
	 private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	    private static final String URL = "jdbc:mysql://localhost:3306/weather?serverTimezone=Asia/Seoul";
	    private static final String UID = "weather";
	    private static final String PWD = "1234";

	    @Test
	    public void connectTest() {
		
	        Connection con = null;
	        try {
	            Class.forName(DRIVER);
	            con = DriverManager.getConnection(URL,UID,PWD);
	            if(con != null) {
	                System.out.println("DB 커넥션 성공!");
	                System.out.println("conn : "+con);
	            }else {
	                System.out.println("DB정보를 받지 못했습니다.");
	                System.out.println("DB연결에 실패 했습니다.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	            try { con.close();}catch(Exception e) {e.printStackTrace();}
	        }
	    }
}
