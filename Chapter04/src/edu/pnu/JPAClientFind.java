package edu.pnu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.pnu.domain.Board;

public class JPAClientFind {

	public static void main(String[] args) {
		//EntityManager 생성. 괄호 안에 persistence-unit name 입력해서 영속성을 구분
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		//팩토리는 어플리케이션에서 하나만 만듬
		EntityManager em = emf.createEntityManager();
		//하나의 비지니스 프로세스 마다?? 하나씩 만들고 다쓰면 닫음(트랜젝션당 메니져 한개씩)
		//Transaction 생성
		//JPA가 테이블에 등록,수정,삭제작업을 처리하기 위해서는 해당작업이 반드시 트랜잭션 안에서 수행되어야함
		EntityTransaction tx = em.getTransaction();
	
		//====검색====
		try {
			Board searchBoard = em.find(Board.class, 1l);
			//find와 persist메소드가 같은 역할을 수행할 수 있다.
			System.out.println(">>>" + searchBoard.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

		emf.close();
		
	}

}
