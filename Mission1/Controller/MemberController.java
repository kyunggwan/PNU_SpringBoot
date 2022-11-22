package com.rubypaper.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.MemberVO;
import com.rubypaprt.service.MemberService;

@RestController
public class MemberController {

	MemberService ms = new MemberService();

	// 출력 - 모든 멤버 정보
	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		return ms.getMembers();
	}

	// 출력 - 아이디가 {id}인 멤버를 출력
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable String id) {
		return ms.getMember(id);
	}

	// 추가 - member를 추가한다
	@PostMapping("/member")
	public MemberVO addMember(MemberVO memberVO) {
		return ms.addMember(memberVO);
	}

	// 수정
	@PutMapping("/member")
	public MemberVO updateMembers(MemberVO memberVO) {
		return ms.updateMembers(memberVO);
	}

	// 삭제
	@DeleteMapping("/member/{id}")
	public MemberVO removeMembers(@PathVariable String id) {
		return ms.removeMembers(id);
	}

}
