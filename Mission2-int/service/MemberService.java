package com.rubypaper.service;

import java.util.List;

import com.rubypaper.domain.MemberDAO;
import com.rubypaper.domain.MemberVO;

public class MemberService {

	// MemberDAO 생성
	private MemberDAO memberDAO;

	public MemberService() {
		// TODO Auto-generated constructor stub
		memberDAO = new MemberDAO();
	}

	// 출력 - 모든 멤버 정보
	public List<MemberVO> getMembers() {
		return memberDAO.getMembers();
	}

	// 출력 - 아이디가 {id}인 멤버를 출력
	public MemberVO getMember(String id) {
		return memberDAO.getMember(id);
	}

	// 추가 - member를 추가한다
	public MemberVO addMember(MemberVO memberVO) {
		return memberDAO.addMember(memberVO);
	}

	// 수정
	public MemberVO updateMembers(MemberVO memberVO) {
		return memberDAO.updateMembers(memberVO);
	}

	// 삭제
	public MemberVO removeMembers(String id) {
		return memberDAO.removeMembers(id);
	}
}
