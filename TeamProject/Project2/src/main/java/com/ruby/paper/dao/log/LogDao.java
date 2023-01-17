package com.ruby.paper.dao.log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class LogDao  {

	// JDBC 드라이버 로드
	Connection con = null;
	public LogDao() {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/db1","first","Xptmxm1!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addLog(String method, String sqlstring, boolean success) {
		PreparedStatement ps = null;
		try {
			String sql = "insert into dblog(method, sqlstring, success) values (?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, method);
			ps.setString(2, sqlstring);
			ps.setBoolean(3, success);
			ps.executeUpdate();
			System.out.println("logged: " + method + " / " + sqlstring + " / " + success);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}