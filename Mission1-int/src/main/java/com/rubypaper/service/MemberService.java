package com.rubypaper.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rubypaper.domain.MemberVO;

public class MemberService {
//리스트 만들고 CRUD만들고 controller에서 호출
	private List<MemberVO> list;

	public MemberService() {
		list = new ArrayList<>();
		for (int i = 1; i <= 2; i++) {
			list.add(new MemberVO(i, "name" + i, "pass" + i, new Date()));
		}
	}

	// CRUD구현
	// 멤버 전체 호출
	public List<MemberVO> getMembers() {
		return list;
	}

//특정멤버 호출
	public MemberVO getMember(Integer id) {
		for (MemberVO m : list) {
			if (m.getId() == id) {
				return m;
			}
		}
		return null;
	}

//추가
	public MemberVO insertMember(MemberVO vo) {
		list.add(new MemberVO(vo.getId(), vo.getName(), vo.getPass(), new Date()));
		return vo;
	}

//수정
	public MemberVO updateMember(MemberVO vo) {
		for (MemberVO m : list) {
			if (m.getId() == vo.getId()) {
				m.setId(vo.getId());
				m.setName(vo.getName());
				m.setPass(vo.getPass());
				return m;
			}
		}
		return null;
	}

//삭제
	public MemberVO deleteMember(Integer id) {
		for (MemberVO m : list) {
			if (m.getId() == id)
				list.remove(m);
			return m;
		}
		return null;
	}
}
