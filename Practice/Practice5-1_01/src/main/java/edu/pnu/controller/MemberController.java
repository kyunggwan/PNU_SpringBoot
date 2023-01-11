package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@Controller
public class MemberController {

	private MemberService ms;
	
	@Autowired
	public MemberController() {
		ms = new MemberService();
		System.out.println("MemberController() 생성자가 호출됨");
	}
	
	//요청방식 및 주소 매핑 어노테이션 기재
	@GetMapping("/member")
	public List<MemberVO> getMembers(){
		System.out.println("MemberController - getMembers() 호출");
		return ms.getMembers();
	}
	
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		System.out.println("MemberController - getMember() 호출");
		return ms.getMember(id);
	}
	
	@PostMapping("/member")
	public MemberVO addMember(MemberVO vo) {
		System.out.println("MemberController - addMember() 호출");
		return ms.addMember(vo);
	}
	
	@PutMapping("/member")
	public MemberVO updateMember(MemberVO vo) {
		System.out.println("MemberController - updateMember() 호출");
		return ms.updateMember(vo);
	}
	
	@DeleteMapping("/member{id}")
	public boolean removeMember(@PathVariable Integer id) {
		System.out.println("MemberController - removeMember() 호출");
		return ms.removeMember(id);
	}
}
