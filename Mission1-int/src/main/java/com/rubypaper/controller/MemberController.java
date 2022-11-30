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

	// 멤버 전체 호출
	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		System.out.println("======멤버 전체 호출======");
		return ms.getMembers();
	}

//특정멤버 호출
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		System.out.println("======특정 전체 호출======");
		return ms.getMember(id);
	}

//추가
	@PostMapping("/member")
	public MemberVO insertMember(MemberVO vo) {
		System.out.println("======멤버 추가======");
		return ms.insertMember(vo);
	}

//수정
	@PutMapping("/member")
	public MemberVO updateMember(MemberVO vo) {
		System.out.println("======멤버 수정하기======");
		return ms.updateMember(vo);
	}

//삭제
	@DeleteMapping("/member")
	public MemberVO deleteMember(Integer id) {
		System.out.println("======멤버 삭제======");
		return ms.deleteMember(id);
	}
}
