package edu.pnu;

import java.util.Date;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
class Chapter5ApplicationTests {
	
	@Autowired
	private BoardRepository boardRepo; 

//	@Test
//	void testDeleteBoard() {
//		boardRepo.deleteById(1L);
		//그냥 jpa의 remove는 전달받은 영속성컨텍스트? 객체의 값도 다 삭제
		//스프링부트의 delete는 영속성컨텍스트 삭제 안함???
		//둘다 데이터베이스에서는 삭제됨
	
	//delete, save메소드는 delete, insert 하기전에 select를 먼저 수행해서 원하는 정보가 db에 있는지 확인한 후 작업 수행
//	}
//	void testUpdateBoard() {
//		System.out.println("=== 1번 게시글 조회 ===");
//		Board board = boardRepo.findById(1L).get();
//		System.out.println("=== 1번 게시글 조회 ===");
//		board.setTitle("제목을 수정");
//		boardRepo.save(board);
//	}
//	void testGetBoard() {
//		Board board = boardRepo.findById(2L).get();
//		System.out.println(board.toString());
//	}
	void contextLoads() {
		
//		List<Board> list = boardRepo.findAll();
//		
//		for(Board m : list) {
//			System.out.println(m.toString());
//			
//		}
		Random random = new Random();
		for(int i=1; i<=100; i++) {
			boardRepo.save(new Board(
					"title"+i,
					"writer"+i,
					"content"+i,
					new Date(),
					random.nextLong(100)
					));
		}
		//어노테이션 Id필드를 10L로 넣었을 때 테이블의 열이 10개만 만들어짐(반복명령이 더 많아도)
		//save 메소드에 의해서 일단 10L이 있는지 select문을 먼저 날림
		//없으면 insert를 하지만 있으면 update를 함.
		//insert를 할떄는 @GeneratedValue(strategy = GenerationType.IDENTITY)에 의해서 10L전까지는 순서대로 입력됨
		//seq 10L까지만 insert를 한 뒤에 11L이 입력되는게 아니라 10L이 update되기 시작
		//null을 넣으면 그냥 실행이 됨
		//https://wangtak.tistory.com/2  참조
	}
}
