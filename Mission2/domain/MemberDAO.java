package com.rubypaper.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

public class MemberDAO extends JDBConnectH2 {

	public MemberDAO() {
		super();
	}

	// 출력(모든멤버)를 구현
	public List<MemberVO> getMembers() {
		// MemberVO형식의 List 생성
		List<MemberVO> list = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from mvcmember");
			while (rs.next()) {
				MemberVO m = new MemberVO(); // 회원정보 객체 생성
				m.setId(rs.getString("id"));
				m.setName(rs.getString("name"));
				m.setPass(rs.getString("pass"));
				list.add(m); // 리스트에 넣음
				System.out.println("모든 멤버 getMembers/DAO 실행");
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

	// 출력 - 특정id
	public MemberVO getMember(String id) {

		MemberVO m = new MemberVO();
		String query = "select * from mvcmember where id = ?"; // 쿼리문 설정
		try {
			PreparedStatement psmt = con.prepareStatement(query); // 쿼리문 준비
			psmt.setString(1, id); // 인파라미터 설정
			rs = psmt.executeQuery();// 쿼리문 실행

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
		return m; // MemberVO형식의 객체 m을 반환
	}

	// 추가
	public MemberVO addMember(MemberVO membervo) {

		String query = "insert into MVCMEMBER(ID, PASS, NAME)" + "values(?,?,?)";// 쿼리문
		try {
			PreparedStatement psmt = con.prepareStatement(query);// 쿼리문 준비
			psmt.setString(1, membervo.getId()); // 인 파라미터 설정
			psmt.setString(2, membervo.getPass());
			psmt.setString(3, membervo.getName());
			System.out.println("addMember DAO 실행");
			psmt.execute();// 쿼리 실행 == H2의 mvcmember에 데이터 넣음
		} catch (Exception e) {
			e.printStackTrace();
		}
		return membervo;// 삽입한 데이터 반환
	}

	// 수정, 업데이트
	public MemberVO updateMembers(MemberVO m) {

		String query = "update MVCMEMBER set PASS = ?, NAME = ? where id = ?"; // 쿼리문
		try {
			PreparedStatement psmt = con.prepareStatement(query); // 쿼리문 준비
			psmt.setString(1, m.getPass());// 인 파라미터 설정
			psmt.setString(2, m.getName());
			psmt.setString(3, m.getId());
			System.out.println("updateMembers DAO실행");
			psmt.executeUpdate();// 쿼리문 실행
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}

	// 삭제
	public MemberVO removeMembers(@PathVariable String id) {
		String query = "delete from MVCMEMBER where ID = ?";// 쿼리문

		try {
			PreparedStatement psmt = con.prepareStatement(query);// 쿼리문 준비
			psmt.setString(1, id);// 인파라미터 설정
			System.out.println("removeMembers DAO실행");
			psmt.execute();// 쿼리 실행
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
