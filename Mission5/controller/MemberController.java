package com.rubypaper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	public MemberController(MemberService ms) {
		this.ms = new MemberService();
	}

	// 출력 - 모든 멤버 정보
	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		System.out.println("출력되는지 확인 ====id 출력=====");
		return ms.getMembers();
	}

	// 출력 - 아이디가 {id}인 멤버를 출력
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable String id) {
		System.out.println("출력되는지 확인 ====특정 id 출력=====");
		return ms.getMember(id);
	}

//	@GetMapping("/member/body") // JSON으로 데이터를 요청하는 경우
//	public MemberVO getMemberbyJSON(@RequestBody MemberVO memberVO) {
//		log.info(String.format("MemberController - getMemberbyJSON(%s)이 호출됨.", memberVO));
//		System.out.println("출력되는지 확인 ====json으로 데이터 요청하는 경우 출력=====");
//		return ms.getMember(memberVO.getId());
//	}

	// 추가 - member를 추가한다
	@PostMapping("/member")
	public MemberVO addMember(MemberVO memberVO) {
		System.out.println("출력되는지 확인 ====addMember 출력=====");
		return ms.addMember(memberVO);
	}

	// 수정
	@PutMapping("/member")
	public MemberVO updateMembers(MemberVO memberVO) {
		System.out.println("출력되는지 확인 ====updateMember 출력=====");
		return ms.updateMembers(memberVO);
	}

	// 삭제
	@DeleteMapping("/member/{id}")
	public MemberVO removeMembers(@PathVariable String id) {
		System.out.println("출력되는지 확인 ====deleteMember 출력=====");
		return ms.removeMembers(id);
	}

}
