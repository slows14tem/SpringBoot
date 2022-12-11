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

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
	
		//====검색====
		try {
			Board searchBoard = em.find(Board.class, 1l);
			//find를 통해서도 엔티티를 영속상태로 만들 수 있다.(조회목표가 없을 경우 새로운 엔티티 객체 생성하여 영속성컨텍스트에 저장)
			//find와 persist메소드가 같은 역할을 수행
			System.out.println(">>>" + searchBoard.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

		emf.close();
		
	}

}
