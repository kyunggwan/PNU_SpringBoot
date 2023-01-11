package edu.pnu.dao.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDaoListImpl implements MemberDao {
	
	//MemberVO형식의 데이터를 담을 list 생성
	List<MemberVO> list;

	//list를 생성한다.
	public MemberDaoListImpl() {
		list = new ArrayList();
		for (int i = 1; i <= 3; i++) {
			list.add(new MemberVO("id" + i, "name" + i, "pass" + i, new Date()));
		}
	}

	@Override
	public List<MemberVO> getMembers() {
		return list;
	}

	@Override
	public MemberVO getMember(String id) {
		for (MemberVO m : list) {
			if (m.getId().equals(id)) {
				return m;
			}
		}
		return null;
	}

	@Override
	public MemberVO addMember(MemberVO mv) {
		mv.setRegidate(new Date());
		list.add(mv);
		return mv;
	}

	@Override
	public MemberVO updateMember(MemberVO mv) {
		for (MemberVO m : list) {
			if (m.getId().equals(mv.getId())) {
				m.setName(mv.getName());
				m.setPass(mv.getPass());
				m.setRegidate(new Date());
				return m;
			}
		}
		return null;
	}

	@Override
	public boolean deleteMember(String id) {
		for (MemberVO m : list) {
			if (m.getId().equals(id)) {
				list.remove(m);
				return true;
			}
		}
		return false;
	}

}
