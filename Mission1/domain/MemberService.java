package com.rubypaprt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.rubypaper.domain.MemberVO;

public class MemberService {
	// 값이 들어갈 List 생성, 생성자에서 데이터 설정 한번만
	private List<MemberVO> MemberList;

	public MemberService() {
		System.out.println("===> MemberService 샘플");

		MemberList = new ArrayList<MemberVO>();
		for (int i = 1; i <= 2; i++)
			MemberList.add(new MemberVO("id" + i, i + "번째 이름", "pass" + i, new Date()));
		System.out.println("===> MemberController 샘플");
	}

	// 출력 - 모든 멤버 정보
	public List<MemberVO> getMembers() {
		System.out.println("모든멤버 getMembers");
		return MemberList;
	}

	// 출력 - 아이디가 {id}인 멤버를 출력
	public MemberVO getMember(@PathVariable String id) {
		for (MemberVO m : MemberList) {
			if (m.getId().equals(id))
				return m;
		}
		return null;
	}

	// 추가 - member를 추가한다
	public MemberVO addMember(MemberVO memberVO) {
		System.out.println("addMember");
		// MemberList에 추가
		MemberList.add(memberVO);
		return memberVO;
	}

	// 수정
	public MemberVO updateMembers(MemberVO memberVO) {
		// 수정부분 이름, 비밀번호 변경
		for (MemberVO m : MemberList) {
			if (m.getId().equals(memberVO.getId())) {
				m.setName(memberVO.getName());
				m.setPass(memberVO.getPass());
				return m;
			}
		}
		return null;
	}

	// 삭제
	public MemberVO removeMembers(@PathVariable String id) {
		// 아이디가 {id}인 member 찾기
		for (MemberVO m : MemberList) {
			if (m.getId().equals(id)) {
				MemberList.remove(m);
				System.out.println(id + "삭제");
				return m;
			}
		}
		return null;
	}
}
