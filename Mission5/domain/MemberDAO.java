package com.rubypaper.domain;

import java.util.List;

public interface MemberDAO {

	List<MemberVO> getMembers();

	MemberVO getMember(String id);

	MemberVO addMember(MemberVO membervo);

	MemberVO updateMembers(MemberVO m);

	MemberVO removeMembers(String id);

	String getSql();

}