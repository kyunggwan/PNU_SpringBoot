package com.rubypaprt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.rubypaper.domain.MemberDAO;
import com.rubypaper.domain.MemberVO;

public class MemberService {
	// 값이 들어갈 List 생성, 생성자에서 데이터 설정 한번만
	private List<MemberVO> MemberList;

	// MemberDAO 생성
	private MemberDAO memberDAO;

	public MemberService() {
		System.out.println("===> MemberService 샘플");

		// memberDAO 생성자
		memberDAO = new MemberDAO();

		MemberList = new ArrayList<MemberVO>();
		for (int i = 1; i <= 2; i++)
			MemberList.add(new MemberVO("id" + i, i + "번째 이름", "pass" + i, new Date()));
		System.out.println("===> MemberController 샘플");
	}

	// 출력 - 모든 멤버 정보
	public List<MemberVO> getMembers() {
		System.out.println("모든멤버 getMembers/service");
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
	public MemberVO removeMembers(@PathVariable String id) {
		return memberDAO.removeMembers(id);
	}
}
