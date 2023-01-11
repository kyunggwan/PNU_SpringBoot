package edu.pnu.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.MemberVO;

@Service
public class MemberService {
	
//	@Autowired
//	private MemberInterface dao;
//	@Autowired
//	private Member LogInterface log;

	
	public List<MemberVO> getMembers(){
		//자기자신을 받는 객체 생성
		List<MemberVO> list = dao.getMembers();
		//실행결과값 있을 때와 없을 때에 따라 success 내용 다르게 로그 남기기
		if(list!=null) {
			log.addLog("get", dao.getSql(), true);
		} else {
			log.addLog("get", dao.getSql(), false);
		}
		return list;
	}
	
	public MemberVO getMember(Integer id) {
		MemberVO m = dao.getMember(id);
		if(m!=null) {
			log.addLog("get", dao.getSql(), true);
		} else {
			log.addLog("get", dao.getSql(), false);
		}
		return m;
	}
	
	public MemberVO addMember(Integer id) {
		MemberVO m = dao.addMember(vo);
		if(m!=null) {
			log.addLog("Post", getSql(), true);
		} else {
			log.addLog("Post", getSql(), false);
		}
		return m;
	}
	
	public MemberVO updateMember(Integer id) {
		MemberVO m = dao.updateMember(vo);
		if(m!=null) {
			log.addLog("put", dao.getSql(), true);
		}else {
			log.addLog("put", dao.getSql(), false);
		}
		return m;
	}
	
	public boolean removeMember(Integer id) {
		boolean m = dao.removeMember(id);
		if(m == true) {
			log.addLog("delete", dao.getSql(), true);
		} else {
			log.addLog("delete", dao.getSql(), false);
		}
		return m;
	}
}
