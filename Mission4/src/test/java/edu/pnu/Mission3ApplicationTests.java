package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.MemberDAO;
import edu.pnu.domain.MemberVO;

@SpringBootTest
class Mission3ApplicationTests {
	
	@Autowired
	private MemberDAO dao;
	
	@Test
	void dbTest() {
		MemberVO m = dao.getMember("musthave1");
		System.out.println(m);
		
	}
	
//	void dbTest() {
//		MemberDAO dao = new MemberDAOH2();
//		MemberVO m = dao.getMember("musthave1");
//		System.out.println(m);
//		
//	}

	@Test
	void test01() {
		System.out.println("test01");
	}
	@Test
	void test02() {
		System.out.println("test02");
	}
	@Test
	void test03() {
		System.out.println("test03");
	}
	

}
