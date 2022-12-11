package edu.pnu;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
public class QueryMethod {
	@Autowired
	private BoardRepository boardRepo; 
	
//	@Test
	public void testFindbyTitle() {
		
		Random random = new Random();
		
		List<Board> boardList = boardRepo.findByTitle("title4");
		
		System.out.println("검색결과");
		for (Board board:boardList) {
			System.out.println("--->" + board.toString());
			
		}
	}
	
	//@Test
	public void testbyContentContaining() {
		List<Board> boardList = boardRepo.findByContentContaining("17");
		System.out.println("검색결과");
		for (Board board:boardList) {
			System.out.println("--->" + board.toString());
			
		}
	}
	
	//@Test
	public void testfindByTitleContainingOrContentContaining() {
		List<Board> boardList = boardRepo.findByTitleContainingAndContentContaining("17", "18");
		System.out.println("검색결과");
		for (Board board:boardList) {
			System.out.println("--->" + board.toString());
			
		}
	}
	
//	@Test
	public void testfindByTitleContainingOrderBySeqDesc() {
		List<Board> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("7");
		System.out.println("검색결과");
		for (Board board:boardList) {
			System.out.println("--->" + board.toString());
			
		}
	}
	
	//@Test
	public void testfindByTitleContaining() {
		Pageable paging = PageRequest.of(4, 10, Sort.Direction.DESC, "seq");
		//(페이지 번호, 데이터 갯수, 정렬방향, 정렬 대상)
		List<Board> boardList = boardRepo.findByTitleContaining("7", paging);
		System.out.println("검색결과");
		for (Board board:boardList) {
			System.out.println("--->" + board.toString());
			
		}
	}
	
	//@Test
	public void testfindByTitleContainingAndCntGreaterThan() {
		List<Board> boardList = boardRepo.findByTitleContainingAndCntGreaterThan("1", 50L);
		System.out.println("검색결과");
		for (Board board:boardList) {
			System.out.println("--->" + board.toString());
			
		}
	}
	
	//@Test
	public void testfindByCntGreaterThanEqualAndLessThanEqual() {
		List<Board> boardList = boardRepo.findByCntGreaterThanEqualAndCntLessThanEqualOrderBySeqAsc(10L, 50L);
		System.out.println("검색결과");
		for (Board board:boardList) {
			System.out.println("--->" + board.toString());
			
		}
	}
	
	//@Test
	public void testfindByTitleContainingOrContentContainingOrderBySeqDesc() {
		List<Board> boardList = boardRepo.findByTitleContainingOrContentContainingOrderBySeqDesc("10", "2");
		System.out.println("검색결과");
		for (Board board:boardList) {
			System.out.println("--->" + board.toString());
			
		}
	}
}
