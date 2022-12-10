package edu.pnu;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
class Chapter6ApplicationTests {
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private BoardRepository boardRepo;

//	@Test
	void contextLoads() {
		Member m1 = new Member();
		m1.setId("member1");
		m1.setPassword("member111");
		m1.setName("둘리");
		m1.setRole("User");
		memberRepo.save(m1);
		
		Member m2 = new Member();
		m2.setId("member2");
		m2.setPassword("member222");
		m2.setName("도우너");
		m2.setRole("Admin");
		memberRepo.save(m2);
		
		for(int i=1;i<=3;i++) {
			Board b1 = new Board();
			b1.setMember(m1);
			b1.setTitle("둘리가 등록한 게시글 " + i);
			b1.setContent("둘리가 등록한 게시글 내용 " + i);
			b1.setCreateDate(new Date());
			b1.setCnt(0L);
			boardRepo.save(b1);
		}
		
		for(int i=1;i<=3;i++) {
			Board b2 =  new Board();
			b2.setMember(m2);
			b2.setTitle("도우너가 등록한 게시글 "+i);
			b2.setContent("도우너가 등록한 게시글 내용"+i);
			b2.setCreateDate(new Date());
			b2.setCnt(0L);
			boardRepo.save(b2);
		}
	}
	
	@Test
	public void ManyToOneTest() {
		Board board = boardRepo.findById(5L).get();
		System.out.println(board.toString());
	}
	//연관관계 매핑으로 인해서 게시물을 검색해도 작성자정보를 확인할 수 있음
	//Board [seq=5, title=도우너가 등록한 게시글 2, content=도우너가 등록한 게시글 내용2, 
	//createDate=2022-12-10 00:00:00.0, cnt=0, 
	//member=Member [id=member2, password=member222, name=도우너, role=Admin]]

}
