package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;

public class MemberService {

	private MemberDao dao;

	public MemberService() {
		dao = new MemberDao();
	}

	public List<MemberVO> getMembers() {
		return dao.getMembers();
	}

	public MemberVO getMember(String id) {
		return dao.getMember(id);
	}

	public MemberVO addMember(MemberVO mv) {
		return dao.addMember(mv);
	}

	public MemberVO updateMember(MemberVO mv) {
		return dao.updateMember(mv);
	}

	public boolean deleteMember(String id) {
		return dao.deleteMember(id);
	}
}
