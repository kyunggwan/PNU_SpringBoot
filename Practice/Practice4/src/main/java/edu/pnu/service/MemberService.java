package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.log.LogDao;
import edu.pnu.dao.log.LogDaoFileImpl;
import edu.pnu.dao.member.MemberDao;
import edu.pnu.dao.member.MemberDaoListImpl;
import edu.pnu.domain.MemberVO;

public class MemberService {

	private MemberDao dao;
	private LogDao log;

	public MemberService() {
		
		//dao 선택
//		dao = new MemberDaoH2Impl();
		dao = new MemberDaoListImpl();
	
		//log 선택
		log = new LogDaoFileImpl();
//		log = new LogDaoH2Impl();
	
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
