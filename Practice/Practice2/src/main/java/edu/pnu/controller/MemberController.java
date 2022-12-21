package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {

	private MemberService MemberService;

	public MemberController() {
		MemberService = new MemberService();
	}

	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		return MemberService.getMembers();
	}

	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable String id) {
		return MemberService.getMember(id);
	}

	@PostMapping("/member")
	public MemberVO addMember(MemberVO mv) {
		return MemberService.addMember(mv);
	}

	@PutMapping("/member")
	public MemberVO updateMember(MemberVO mv) {
		return MemberService.updateMember(mv);
	}

	@DeleteMapping("/member/{id}")
	public boolean deleteMember(@PathVariable String id) {
		return MemberService.deleteMember(id);
	}
}
