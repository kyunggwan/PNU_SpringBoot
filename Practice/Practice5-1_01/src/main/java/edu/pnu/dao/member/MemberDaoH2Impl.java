package edu.pnu.dao.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.IvParameterSpec;

import org.springframework.stereotype.Repository;

import edu.pnu.domain.MemberVO;

@Repository
public class MemberDaoH2Impl implements MemberInterface {

	private Connection con = null;

	private String sqlString;

	public MemberDaoH2Impl() {
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/mission", "sa", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// select * from table
	@Override
	public List<MemberVO> getMembers() {
		// 결과값 저장할 list 선언
		List<MemberVO> list = new ArrayList<>();

		// sql문 실행하는 객체 생성
		Statement st = null;

		// sql문 실행 결과 받는 ResultSet생성
		ResultSet rs = null;

		try {
			// con에서 객체 부여
			String sql = "select * from member";
			sqlString = sql;
			st = con.createStatement();
			rs = st.executeQuery(sql);

			// rs의 다음값이 있으면 list에 rs 추가
			while (rs.next()) {
				// list에 넣을 MemberVO 객체 m 선언
				MemberVO m = new MemberVO();
				// rs가 가진 값을 m에 넣어주기
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setPass(rs.getString("pass"));
				m.setRegidate(rs.getDate("regidate"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("getMembers Success");
		return list;
	}

	@Override
	public MemberVO getMember(Integer id) {

	}

	// 최댓값 다음 수를 찾아주는 메소드
	private int getNextId() {
		// sql문 실행 객체
		Statement st = null;
		// sql문 실행 결과
		ResultSet rs = null;

		try {
			// id열 중 최댓값을 구하는 쿼리문
			String sql = "select max(id) from member";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			// rs : max값 앞을 가리킴
			// rs.next() : max값을 가리킴
			rs.next();
			// rs 내 요소 1개 > rs의 첫번째 요소(max값)를 가져와서 +1
			return rs.getInt(1) + 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}

	@Override
	public MemberVO addMember(MemberVO vo) {

	}

	@Override
	public MemberVO updateMember(MemberVO vo) {

	}

	@Override
	public boolean removeMember(Integer id) {

		PreparedStatement ps = null;
		try {
			String sql = "delete from member where id = ?";
			sqlString = String.format("delete from member where id ='%d'", id);
			// sql문 실행 객체
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			if(ps.executeUpdate() == 1) {
				System.out.println("deleteMember Success");
				return true;
			}
		} catch (Exception e) {
			
		}
	}

	@Override
	public String getSql() {

		return sqlString;
	}

}
