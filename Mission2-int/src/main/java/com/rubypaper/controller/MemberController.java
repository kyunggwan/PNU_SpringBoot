package com.rubypaper.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.MemberVO;
import com.rubypaper.service.MemberService;

@RestController
public class MemberController {

	private MemberService ms;

	public MemberController() {
		ms = new MemberService();
	}

	// 출력 - 모든 멤버 정보
	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		System.out.println("모든멤버 getMembers");
		return ms.getMembers();
	}

	// 출력 - 아이디가 {id}인 멤버를 출력
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable String id) {
		System.out.println("특정멤버 getMember");
		return ms.getMember(id);
	}

	// 추가 - member를 추가한다
	@PostMapping("/member")
	public MemberVO addMember(MemberVO memberVO) {
		System.out.println("멤버 추가 addmember");
		return ms.addMember(memberVO);
	}

	// 수정
	@PutMapping("/member")
	public MemberVO updateMembers(MemberVO memberVO) {
		System.out.println("멤버 수정 updatemember");
		return ms.updateMembers(memberVO);
	}

	// 삭제
	@DeleteMapping("/member/{id}")
	public MemberVO removeMembers(@PathVariable String id) {
		System.out.println("멤버 삭제 deletemember");
		return ms.removeMembers(id);
	}

}
