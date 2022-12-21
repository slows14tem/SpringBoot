package edu.pnu.service;

import java.util.List;

import org.springframework.data.domain.Page;

import edu.pnu.domain.Board;
import edu.pnu.domain.Search;

public interface BoardService {
	
	void insertBoard(Board board);

	void updateBoard(Board board);

	void deleteBoard(Board board);

	Board getBoard(Board board);
	
	Page<Board> getBoardList(Search search, int page);
//	List<Board> getBoardList(Search search);
}
