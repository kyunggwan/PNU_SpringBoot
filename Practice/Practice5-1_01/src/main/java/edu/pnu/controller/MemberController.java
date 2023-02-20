package edu.pnu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {

	private MemberService ms;

	// Logger추가
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	public MemberController(MemberService ms) {
		this.ms = ms;
		log.info("MemberController() 생성자가 호출됨.");
	}

	// 요청방식 및 주소 매핑 어노테이션 기재
	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		log.info("MemberController - getmembers()가 호출됨.");
		return ms.getMembers();
	}

	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		log.info(String.format("MemberController - getMember(%d)가 호출됨", id));
		return ms.getMember(id);
	}
	
	@GetMapping("/member/body") // JSON으로 데이터를 요청하는 경우
	public MemberVO getMemberbyJSON(@RequestBody MemberVO member) {
		log.info(String.format("MemberController - getMemberbyJSON(%s)이 호출됨.", member));
		return ms.getMember(member.getId());
	}

	@PostMapping("/member")
	public MemberVO addMember(MemberVO vo) {
		log.info("MemberController - addMember()가 호출됨.");
		return ms.addMember(vo);
	}

	@PutMapping("/member")
	public MemberVO updateMember(MemberVO vo) {
		log.info("MemberController - updateMember()가 호출됨.");
		return ms.updateMember(vo);
	}

	@DeleteMapping("/member/{id}")
	public MemberVO deleteMember(@PathVariable Integer id) {
		log.info(String.format("MemberController - removeMember(%d)가 호출됨", id));
		return ms.deleteMember(id);
	}
}
