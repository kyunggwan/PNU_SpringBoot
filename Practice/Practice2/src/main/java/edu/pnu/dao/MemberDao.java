package edu.pnu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDao {

	private Connection con = null;

	public MemberDao() {
		try {
			// JDBC 드라이버 로드
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/mission", "sa", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<MemberVO> getMembers() {
//
//		Statement st = null;
//		ResultSet rs = null;
//
//		List<MemberVO> list = new ArrayList<>();
//		String query = "Select * from member";
//
//		try {
//			st = con.createStatement();
//			rs = st.executeQuery(query);
//
//			while (rs.next()) {
//				MemberVO m = new MemberVO();
//				m.setId(rs.getString("id"));
//				m.setName(rs.getString("name"));
//				m.setPass(rs.getString("pass"));
//				m.setRegidate(rs.getDate("regidate"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				rs.close();
//				st.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return list;
//	}
		Statement st = null;
		ResultSet rs = null;
		List<MemberVO> list = new ArrayList<>();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from member order by id asc");
			while(rs.next() ) {
				MemberVO m = new MemberVO();
				m.setId(rs.getString("id"));
				m.setPass(rs.getString("pass"));
				m.setName(rs.getString("name"));
				m.setRegidate(rs.getDate("regidate"));
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
		return list;
	}

	public MemberVO getMember(String id) {
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//
//		String query = "Select * from member where id = %d";
//
//		try {
//			ps = con.prepareStatement(query);
//			ps.setString(1, id);
//			rs = ps.executeQuery();
//			rs.next();
//
//			MemberVO m = new MemberVO();
//			m.setId(rs.getString(id));
//			m.setName(rs.getString("name"));
//			m.setPass(rs.getString("pass"));
//			m.setRegidate(rs.getDate("regidate"));
//			return m;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				rs.close();
//				ps.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement("select * from member where id=?");
			st.setString(1, id);
			rs = st.executeQuery();
			rs.next();
			MemberVO m = new MemberVO();
			m.setId(rs.getString(id));
			m.setPass(rs.getString("pass"));
			m.setName(rs.getString("name"));
			m.setRegidate(rs.getDate("regidate"));
			return m;
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
		return null;
	}

	public MemberVO addMember(MemberVO mv) {

//		PreparedStatement ps = null;
//		String query = "insert into member values (id, name, pass) values (?,?,?)";
//
//		try {
//			ps = con.prepareStatement(query);
//			ps.setString(1, mv.getId());
//			ps.setString(2, mv.getName());
//			ps.setString(3, mv.getPass());
////			ps.setDate(4, new Date(System.currentTimeMillis()));
//			ps.executeUpdate();
//
//			return getMember(mv.getId());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
		PreparedStatement st = null;
		try {
			st = con.prepareStatement("insert into member (id,name,pass,regidate) values (?,?,?,?)");
			st.setString(1, mv.getId());
			st.setString(2,	mv.getName());
			st.setString(3, mv.getPass());
			st.setDate(4, new Date(System.currentTimeMillis()));
			st.executeUpdate();

			return getMember(mv.getId());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

		
	public MemberVO updateMember(MemberVO mv) {

		PreparedStatement ps = null;
		String query = "update member set name=?,pass=? where id=?";

		try {
			ps = con.prepareStatement(query);
			ps.setString(1, mv.getName());
			ps.setString(2, mv.getPass());
			ps.setString(3, mv.getId());
			ps.executeUpdate();

			return getMember(mv.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteMember(String id) {

		PreparedStatement ps = null;
		String query = "delete * from member where id = ?";

		try {
			ps = con.prepareStatement(query);
			ps.setString(1, id);
			if (ps.executeUpdate() == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
