package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class Practice1Service {

	List<MemberVO> MemberList;

	public Practice1Service() {
		MemberList = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			MemberList.add(new MemberVO("id" + i, "name" + i, "pass" + i, new Date()));
		}
	}

	public List<MemberVO> getMembers() {
		return MemberList;
	}

	public MemberVO getMember(String id) {

		for (MemberVO m : MemberList) {
			if (m.getId().equals(id)) {
				return m;
			}
		System.out.println("서비스");
		}
		return null;
	}

	public MemberVO addMember(MemberVO mv) {
		mv.setId(mv.getId() + (MemberList.size() + 1));
		mv.setRegidate(new Date());
		MemberList.add(mv);
		return mv;
	}

	public MemberVO updateMember(MemberVO mv) {

		for (MemberVO m : MemberList) {
			if (m.getId().equals(mv.getId())) {
				m.setName(mv.getName());
				m.setPass(mv.getPass());
				m.setRegidate(new Date());
				return mv;
			}
		}
		return null;
	}

	public MemberVO deleteMember(String id) {

		for (MemberVO m : MemberList) {
			if (m.getId().equals(id)) {
				MemberList.remove(m);
				return m;
			}
		}
		return null;
	}

}
