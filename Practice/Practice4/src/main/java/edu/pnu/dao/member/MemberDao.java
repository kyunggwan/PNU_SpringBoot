package edu.pnu.dao.member;

import java.util.List;

import edu.pnu.domain.MemberVO;

public interface MemberDao {

	List<MemberVO> getMembers();

	MemberVO getMember(String id);

	MemberVO addMember(MemberVO mv);

	MemberVO updateMember(MemberVO mv);

	boolean deleteMember(String id);

}