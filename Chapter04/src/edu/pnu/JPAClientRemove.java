package edu.pnu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.pnu.domain.Board;

public class JPAClientRemove {

	public static void main(String[] args) {
		//EntityManager 생성. 괄호 안에 persistence-unit name 입력해서 영속성을 구분
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		//팩토리는 어플리케이션에서 하나만 만듬
		EntityManager em = emf.createEntityManager();
		//하나의 비지니스 프로세스 마다?? 하나씩 만들고 다쓰면 닫음(트랜젝션당 메니져 한개씩)
		//Transaction 생성
		//JPA가 테이블에 등록,수정,삭제작업을 처리하기 위해서는 해당작업이 반드시 트랜잭션 안에서 수행되어야함
		EntityTransaction tx = em.getTransaction();
		//=====입력=====
		try {
			tx.begin();
			//삭제할 게시글 조회
			Board board1 = em.find(Board.class, 3L);
//			board1.setSeq(3L);	//없어도 돌아감
			//find메소드로 board1에 이미 seq 3L이 저장되어있는데 다시 setSeq로 3L로 바꿔줄 필요없는듯.
			//게시글 삭제
			em.remove(board1);
			//transaction commit
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
