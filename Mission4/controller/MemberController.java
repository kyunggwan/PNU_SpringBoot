package com.rubypaper.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.MemberVO;
import com.rubypaper.service.MemberService;

@RestController
public class MemberController {

	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	private MemberService ms;

	public MemberController() {
		log.info("MemberController() 생성자가 호출됨.");
		ms = new MemberService();
	}

	// 출력 - 모든 멤버 정보
	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		log.info("MemberController - getMembers()가 호출됨.");
		return ms.getMembers();
	}

	// 출력 - 아이디가 {id}인 멤버를 출력
	@GetMapping("/member/{id}")
	public MemberVO getMember(String id) {
		log.info(String.format("MemberController - getMember(%d)가 호출됨.", id));
		return ms.getMember(id);
	}

	@GetMapping("/member/body") // JSON으로 데이터를 요청하는 경우
	public MemberVO getMemberbyJSON(@RequestBody MemberVO memberVO) {
		log.info(String.format("MemberController - getMemberbyJSON(%s)이 호출됨.", memberVO));
		return ms.getMember(memberVO.getId());
	}

	// 추가 - member를 추가한다
	@PostMapping("/member")
	public MemberVO addMember(MemberVO memberVO) {
		log.info(String.format("MemberController - addMember(%s)가 호출됨.", memberVO));
		return ms.addMember(memberVO);
	}

	// 수정
	@PutMapping("/member")
	public MemberVO updateMembers(MemberVO memberVO) {
		log.info(String.format("MemberController - updateMember(%s)가 호출됨.", memberVO));
		return ms.updateMembers(memberVO);
	}

	// 삭제
	@DeleteMapping("/member")
	public MemberVO removeMembers(String id) {
		log.info(String.format("MemberController - deleteMember(%ㅇ)가 호출됨.", id));
		return ms.removeMembers(id);
	}

}
