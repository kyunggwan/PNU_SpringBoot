package com.rubypaper.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberDaoListImpl implements MemberDAO {

	private List<MemberVO> MemberList;

	public MemberDaoListImpl() {
		MemberList = new ArrayList<MemberVO>();
		for (int i = 1; i <= 2; i++) {
			MemberList.add(new MemberVO("id" + i, "name" + i, "pass" + i, new Date()));
		}
	}

	@Override
	public List<MemberVO> getMembers() {
		System.out.println("모든 멤버 출력");
		return MemberList;
	}

	@Override
	public MemberVO getMember(String id) {
		for (MemberVO m : MemberList) {
			if (m.getId().equals(id)) {
				System.out.println(m + "멤버 추가");
				return m;
			}
		}
		return null;
	}

	@Override
	public MemberVO addMember(MemberVO membervo) {
		MemberList.add(membervo);
		System.out.println(membervo + "멤버 추가");
		return membervo;
	}

	@Override
	public MemberVO updateMembers(MemberVO membervo) {
		for (MemberVO m : MemberList) {
			if (m.getId().equals(membervo.getId())) {
				m.setName(membervo.getName());
				m.setPass(membervo.getPass());
				System.out.println(m + "멤버 업데이트");
				return m;
			}

		}
		return null;
	}

	@Override
	public MemberVO removeMembers(String id) {
		for (MemberVO m : MemberList) {
			if (m.getId().equals(id)) {
				MemberList.remove(m);
				System.out.println(m + "멤버 삭제");
				return m;
			}
		}
		return null;
	}
}
