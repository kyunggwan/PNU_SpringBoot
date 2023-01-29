package com.edu;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.edu.domain.Board;
import com.edu.persistence.BoardRepository;

public class QueryMethodTest {

	@Autowired
	private BoardRepository boardRepo;

// 	데이터 준비
//	@Test
//	public void dataPrepare() {
//		for (int i = 1; i <= 100; i++) {
//			double a = Math.random() * 100;
//			Long b = (Long) a;
//			Random random = new Random();
//			Board board = new Board();
//			board.setTitle("테스트 제목" + i);
//			board.setWriter("테스터");
//			board.setContent("테스트 내용" + i);
//			board.setCreateDate(new Date());
//			board.setCnt(random.nextLong(100L));
//			boardRepo.save(board);
//		}
//	}
	
//	title이 테스트 제목10인 데이터 출력
	@Test
	public void testFindByTitle() {
		List<Board> boardList = boardRepo.findByTitle("테스트 제목10");

		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("===> " + board.toString());
		}
	}
	
//	17이 포함된 데이터 출력
//	@Test
//	public void testByContentContaining() {
//		List<Board> boardList = boardRepo.findByContentContaining("17");
//
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("===>" + board.toString());
//		}

//	Title에 17이 들어가고, content에 17이 들어간것 출력
//	@Test
//	public void findByTitleContainingOrContentContaining() {
//
//	List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("17", "17");
//
//	System.out.println("검색결과");
//	for (Board board : boardList) {
//		System.out.println("---->" + board.toString());
//	}

//title에 1이 포함되는 데이터 출력
//@Test
//public void findByTitleContaining() {
//
//	List<Board> boardList = boardRepo.findByTitleContaining("1");
//
//	System.out.println("검색결과");
//	for (Board board : boardList) {
//		System.out.println("---->" + board.toString());
//	}
//}

//title에 1이 포함되면서 cnt가 50보다 큰 데이터 출력
//@Test
//public void findByTitleContainingAndCntGreaterThan() {
//
//	List<Board> boardList = boardRepo.findByTitleContainingAndCntGreaterThan("1", 50);
//
//	System.out.println("검색결과");
//	for (Board board : boardList) {
//		System.out.println("---->" + board.toString());
//	}
//}

//cnt가 10~50사이인 데이터를 seq오름차순으로 출력 asc
//@Test
//public void findByCntGreaterThanEqualAndCntLessThanEqualOrderBySeqAsc() {
//
//	List<Board> boardList = boardRepo.findByCntGreaterThanEqualAndCntLessThanEqualOrderBySeqAsc(10, 50);
//
//	System.out.println("검색결과");
//	for (Board board : boardList) {
//		System.out.println("---->" + board.toString());
//	}
//}
}
