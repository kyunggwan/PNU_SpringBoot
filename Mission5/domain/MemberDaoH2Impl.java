package com.rubypaper.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoH2Impl extends JDBConnectH2 implements MemberDAO {

	// sql문을 받기 위한 변수 설정, 일단 동시접속 고려 안함
	private String sql;

	// 명시한 데이터베이스로의 연결이 완료된 MemberDAO 객체를 생성합니다.
	public MemberDaoH2Impl() {
		super();
	}

	@Override
	public List<MemberVO> getMembers() {
		List<MemberVO> list = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from mvcmember");
			sql = "select * from mvcmember";
			while (rs.next()) {
				MemberVO m = new MemberVO();
				m.setId(rs.getString("id"));
				m.setName(rs.getString("name"));
				m.setPass(rs.getString("pass"));
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
		return list;
	}

	@Override
	public MemberVO getMember(String id) {
		MemberVO m = new MemberVO();
		String query = "select * from mvcmember where id = ?";
		sql = String.format("select * from mvcmember where id = '%s'", id);
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			while (rs.next()) {
				if (rs.getString("id").equals(id)) {
					// 쿼리 결과로 얻은 회원 정보를 m 객체에 저장
					m.setId(rs.getString("id"));
					m.setPass(rs.getString(2));
					m.setName(rs.getString(3));
					m.setRegidate(rs.getDate(4));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return m;
	}

	@Override
	public MemberVO addMember(MemberVO membervo) {

		String query = "insert into MVCMEMBER(ID, PASS, NAME)" + "values(?,?,?)";
		sql = String.format("insert into MVCMEMBER(ID, PASS, NAME)" + "values('%s','%s','%s')", membervo.getId(),
				membervo.getPass(), membervo.getName());
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, membervo.getId());
			psmt.setString(2, membervo.getPass());
			psmt.setString(3, membervo.getName());
			System.out.println("addMember H2 DAO 실행");
			psmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return membervo;
	}

	@Override
	public MemberVO updateMembers(MemberVO m) {

		String query = "update MVCMEMBER set PASS = ?, NAME = ? where id = ?";
		sql = String.format("update MVCMEMBER set PASS = '%s', NAME = '%s' where id = '%s'", m.getPass(), m.getName(),
				m.getId());
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, m.getPass());
			psmt.setString(2, m.getName());
			psmt.setString(3, m.getId());
			System.out.println("updateMembers H2 DAO실행");
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public MemberVO removeMembers(String id) {
		MemberVO m = getMember(id);
		String query = "DELETE FROM MVCMEMBER where ID = ?";
		sql = String.format("DELETE FROM MVCMEMBER where ID = '%s'", id);

		try {
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			System.out.println("removeMembers H2 DAO실행");
			psmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public String getSql() {
		return sql;
	}

}
