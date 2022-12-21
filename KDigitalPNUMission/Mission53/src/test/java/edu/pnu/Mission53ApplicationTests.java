package edu.pnu;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Members;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
class Mission53ApplicationTests {
	
	@Autowired
	private MemberRepository memRepo;

	@Test
	void contextLoads() {
		for(int i=1; i<=10;i++) {
			memRepo.save(new Members(
					"id"+i,
					"1234",
					"name"+i,
					new Date()
					));
		}
		
	}

}
