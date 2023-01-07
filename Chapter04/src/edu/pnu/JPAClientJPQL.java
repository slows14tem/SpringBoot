package edu.pnu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.pnu.domain.Board;

public class JPAClientJPQL {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		//=====입력=====
		try {
			//transaction 시작
			tx.begin();

			Board board = new Board();
			board.setTitle("JAP 제목");
			board.setWriter("관리자");
			board.setContent("JPA 글 등록 잘 되네요.");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			//글 등록
			em.persist(board);
			
			String jpql = "select b from Board b order by b.seq desc";
			//sql과 거의 유사, 테이블이 아니라 엔티티를 검색함(엔티티 이름과 변수명을 사용해야함)
			List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
			for (Board brd : boardList) {
				System.out.println("--->" + brd.toString());
			}
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}

	}

}
//JPQL로 검색기능을 수행하면 쿼리를 실행하기 전에 SQL 저장소에 저장된 모든 SQL구문들을 데이터베이스에 전송한다.
//그래야 영속성 컨텍스트에 없는 데이터를 데이터베이스로부터 조회하여 영속성 컨텍스트에 등록할 수 있기 때문이다.
