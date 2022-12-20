package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.Practice1Service;

@RestController
public class Practice1Controller {

	private Practice1Service PracticeService;

	public Practice1Controller() {
		PracticeService = new Practice1Service();
	}

	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		return PracticeService.getMembers();
	}

	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable String id) {
		return PracticeService.getMember(id);
	}

	@PostMapping("/member")
	public MemberVO addMember(MemberVO mv) {
		return PracticeService.addMember(mv);
	}

	@PutMapping("/member")
	public MemberVO updateMember(MemberVO mv) {
		return PracticeService.updateMember(mv);
	}

	@DeleteMapping("/member/{id}")
	public MemberVO deleteMember(@PathVariable String id) {
		return PracticeService.deleteMember(id);
	}
}
