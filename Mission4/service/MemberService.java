package com.rubypaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.MemberDaoH2Impl;
import com.rubypaper.domain.MemberVO;
import com.rubypaper.log.LogDaoH2Impl;

@Service
public class MemberService {

//	// dao
//	@Autowired
	private MemberDaoH2Impl dao;
//	private MemberDaoListImpl dao;
//
//	// 로그
//	@Autowired
	private LogDaoH2Impl log;
	// private LogDaoFileImpl log;

	@Autowired
	public MemberService() {
		dao = new MemberDaoH2Impl();
		// this.dao = new MemberDaoListImpl();

		log = new LogDaoH2Impl();
		// this.log = new LogDaoFileImpl();
	}

	// 출력 - 모든 멤버 정보
	public List<MemberVO> getMembers() {
		List<MemberVO> list = dao.getMembers();
		if (list != null)
			log.addLog("get", dao.getSql(), true);
		else
			log.addLog("get", dao.getSql(), false);
		return list;
	}

	// 아이디가 {id} 인 member를 찾아서 브라우저에 출력
	public MemberVO getMember(String id) {
		MemberVO m = dao.getMember(id);
		if (m != null)
//			log.addLog("get", String.format("getMember(%s)", id), true);
			log.addLog("get", dao.getSql(), true);
		else
//			log.addLog("get", String.format("getMember(%s)", id), false);
			log.addLog("get", dao.getSql(), false);
		return m;
	}

	// 추가하고자 하는 member 정보를 전달, 추가된 객체를 출력
	public MemberVO addMember(MemberVO vo) {
		// 쿼리 실행값을 받아오는 객체 생성
		MemberVO m = dao.addMember(vo);
		if (m != null)
//			log.addLog("post", String.format("addMember(%s)", vo), true);
			log.addLog("post", dao.getSql(), true);
		else
//			log.addLog("post", String.format("addMember(%s)", vo), false);
			log.addLog("post", dao.getSql(), false);
		return m;
	}

	// 수정 대상 객체 정보를 전달, 수정된 객체를 출력
	public MemberVO updateMembers(MemberVO vo) {
		MemberVO m = dao.updateMembers(vo);
		if (m != null)
//			log.addLog("put", String.format("updateMember(%s)", vo), true);
			log.addLog("put", dao.getSql(), true);
		else
//			log.addLog("put", String.format("updateMember(%s)", vo), false);
			log.addLog("put", dao.getSql(), false);
		return m;
	}

	// 아이디가 {id} 인 member를 찾아서 삭제, 브라우저에는 삭제된 객체를 출력
	public MemberVO removeMembers(String id) {
		MemberVO m = dao.removeMembers(id);
		if (m != null)
//			log.addLog("delete", String.format("removeMember(%s)", id), true);
			log.addLog("delete", dao.getSql(), true);
		return m;
	}
}