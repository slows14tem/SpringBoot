package edu.pnu.persistence;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import edu.pnu.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>  { //, QuerydslPredicateExecutor<Board>
	//queryDSL을 사용하기 위해 QuerydslPredicateExecutor<Board> 추가
	
	Page<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword, Pageable paging);
	Page<Board> findByContentContainingOrderBySeqDesc(String searchKeyword, Pageable paging);
	
//	@Query("select b from Board b")
//	Page<Board> getBoardList(Pageable pageable);

}
