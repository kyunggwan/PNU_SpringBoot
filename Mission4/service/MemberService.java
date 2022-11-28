package com.rubypaper.service;

import java.util.List;

import com.rubypaper.domain.MemberDaoListImpl;
import com.rubypaper.domain.MemberVO;
import com.rubypaper.log.LogDaoFileImpl;

public class MemberService {

	// MemberDaoH2Impl dao = new MemberDaoH2Impl();
	MemberDaoListImpl dao = new MemberDaoListImpl();

	// LogDaoH2Impl log = new LogDaoH2Impl();
	LogDaoFileImpl log = new LogDaoFileImpl();

	// 출력 - 모든 멤버 정보
	@SuppressWarnings("unchecked")
	public List<MemberVO> getMembers() {
		List<MemberVO> m = dao.getMembers();
		if (m != null) {
			log.addLog("get", dao.getSql(), true);
			return m;
		}
		log.addLog("get", dao.getSql(), false);
		return null;
	}

	// 아이디가 {id} 인 member를 찾아서 브라우저에 출력
	public MemberVO getMember(String id) {
		MemberVO m = dao.getMember(id);
		if (m != null) {
			log.addLog("get", dao.getSql(), true);
			return m;
		}
		log.addLog("get", dao.getSql(), false);
		return null;
	}

	// 추가하고자 하는 member 정보를 전달, 추가된 객체를 출력
	public MemberVO addMember(MemberVO vo) {
		// 쿼리 실행값을 받아오는 객체 생성
		MemberVO m = dao.addMember(vo);
		if (m != null) {
			// 객체가 null이 아니면 true 로그 기록 및 객체 반환
			log.addLog("post", dao.getSql(), true);
			return m;
		}
		// 객체가 null이면 false 로그 기록 및 null 반환
		log.addLog("post", dao.getSql(), false);
		return null;
	}

	// 수정 대상 객체 정보를 전달, 수정된 객체를 출력
	public MemberVO updateMembers(MemberVO vo) {
		MemberVO m = dao.updateMembers(vo);
		if (m != null) {
			log.addLog("put", dao.getSql(), true);
			return m;
		}
		log.addLog("put", dao.getSql(), false);
		return null;
	}

	// 아이디가 {id} 인 member를 찾아서 삭제, 브라우저에는 삭제된 객체를 출력
	public MemberVO removeMembers(String id) {
		MemberVO m = dao.removeMembers(id);
		if (m != null) {
			log.addLog("delete", dao.getSql(), true);
			return m;
		}
		log.addLog("delete", dao.getSql(), false);
		return m;
	}

}