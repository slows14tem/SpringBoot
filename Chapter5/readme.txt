. 스프링부터에서 제공하는 스프링 데이터 JPA
	
	JpaRepository
		CRUD 기능을 처리할 Repository 인터페이스(DAO와 동일한 개념으로 실질적인 데이터베이스 연동을 처리)
		인터페이스임에도 별도의 구현 클래스 없이 기능을 사용 가능(스프링부트가 내부적으로 구현 객체를 자동으로 생성해줌)
		EntityManagerFactory, EntityManager 같은 객체도 필요없음(스프링 데이터 JPA에서 내부적으로 처리)
	쿼리 메소드 
	@Query 어노테이션 - 쿼리메소드로 처리할 수 없는 복잡한 쿼리문이 필요할 때 직접 JPQL을 사용하는 방법
	QueryDSL - 라이브러리 추가 필요(src/main/querydsl 생성)
