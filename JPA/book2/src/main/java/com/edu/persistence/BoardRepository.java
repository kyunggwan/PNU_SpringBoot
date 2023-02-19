package com.edu.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

	//쿼리 메소드 사용하기
	//게시글 제목으로 목록을 조회하는 findByTitle()메소드를 추가한다.
//	List<Board> findByTitle(String searchKeyword);
	
//	List<Board> findByContentContaining(String searchKeyword);
//페이징 처리
	List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
//	List<Board> findByTitleContainingOrContentContaining(String title, String content);

//	 List<Board> findByTitleContainingCntGreaterthanOrderBySeqDesc(String string, int i);

//	 List<Board> findByTitleContainingAndCntGreaterThan(String string, int i);

//	List<Board> findByCntGreaterThanEqualAndCntLessThanEqualOrderBySeqAsc(int i, int j);
	
}
