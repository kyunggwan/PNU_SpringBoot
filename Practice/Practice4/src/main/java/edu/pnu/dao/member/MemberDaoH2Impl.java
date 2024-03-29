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

import edu.pnu.domain.MemberVO;

public class MemberDaoH2Impl implements MemberDao {

	private Connection con = null;

	public MemberDaoH2Impl() {
		try {
			// JDBC 드라이버 로드
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/mission", "sa", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberVO> getMembers() {

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

	@Override
	public MemberVO getMember(String id) {

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement("select * from member where id=?");
			st.setString(1, id);
			rs = st.executeQuery();
			rs.next();
			MemberVO m = new MemberVO();
			m.setId(rs.getString("id"));
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

	@Override
	public MemberVO addMember(MemberVO mv) {

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

		
	@Override
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

	@Override
	public boolean deleteMember(String id) {

		PreparedStatement ps = null;
		String query = "delete from member where id = ?";

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
