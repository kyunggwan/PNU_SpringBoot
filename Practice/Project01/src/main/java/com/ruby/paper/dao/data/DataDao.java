package com.ruby.paper.dao.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ruby.paper.domain.DataVO;

@Repository
public class DataDao {

	private Connection con = null;
	
	private String sqlString;
	
	public DataDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/db1","first","Xptmxm1!");
		    System.out.println("sql 연결 성공(생성자)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<DataVO> getList(){
		List<DataVO> list = new ArrayList<>();
		
		Statement st = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from car";
			sqlString = sql;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			// rs의 다음값이 있으면 list에 rs 추가
			while (rs.next()) {
				// list에 넣을 DataVO 객체 m 선언
				DataVO m = new DataVO();
				// rs가 가진 값을 m에 넣어주기
				m.setCar_num(rs.getInt("car_num"));
				m.setDistance(rs.getInt("distance"));
				m.setDistance_cum(rs.getInt("distance_cum"));
				m.setSpeed_av(rs.getDouble("speed_av"));
				m.setSpeed_max(rs.getInt("speed_max"));
				m.setOpertating_time(rs.getInt("operating_time"));
				m.setStop_num(rs.getInt("stop_num"));
				m.setStop_time(rs.getInt("stop_time"));
				m.setStop_rate(rs.getDouble("stop_rate"));
				m.setDrive_time(rs.getInt("drive_time"));
				m.setRpm_max(rs.getInt("rpm_max"));
				m.setRpm_av(rs.getInt("rpm_av"));
				m.setResult(false);
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("DataDao - getMembers Success");
		return list;
	}
	
	public String getSql() {
		return sqlString;
	}
}