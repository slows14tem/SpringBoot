package edu.pnu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.domain.Search;
import edu.pnu.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepo;

	public void insertBoard(Board board) {
		boardRepo.save(board);		
	}
	
	public void updateBoard(Board board) {
		Board findBoard = boardRepo.findById(board.getSeq()).get();

		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());		
		boardRepo.save(findBoard);
	}
	
	public void deleteBoard(Board board) {
		boardRepo.deleteById(board.getSeq());
	}	
	
	public Board getBoard(Board board) {
		return boardRepo.findById(board.getSeq()).get();
	}
		
//	public Page<Board> getBoardList(Search search) {		
//		BooleanBuilder builder = new BooleanBuilder();
//		
//		QBoard qboard = QBoard.board;
//		if(search.getSearchCondition().equals("TITLE")) {
//		      builder.and(qboard.title.like("%" + search.getSearchKeyword() + "%"));
//		} else if(search.getSearchCondition().equals("CONTENT")) {
//		      builder.and(qboard.content.like("%" + search.getSearchKeyword() + "%"));
//		}		
//		Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "seq");
//		return boardRepo.findAll(builder, pageable);
//		//at jdk.proxy32/jdk.proxy32.$Proxy262.findAll(Unknown Source) ~[na:na]
//	}

	//모든 보드리스트를 받는 메소드
//	@Override
//	//BooleanBuilder를 사용한 동적쿼리 사용시 에러발생하여 쿼리메소드로 변경하여 검색기능 구현
//	public List<Board> getBoardList(Search search) {
//		Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "seq");
//		List<Board> boardList = new ArrayList<Board>();
//		if(search.getSearchCondition().equals("TITLE")) {
//		    boardList = boardRepo.findByTitleContainingOrderBySeqDesc(search.getSearchKeyword(), pageable);
//		} else if(search.getSearchCondition().equals("CONTENT")) {
//			boardList = boardRepo.findByContentContainingOrderBySeqDesc(search.getSearchKeyword(), pageable);
//		}
//		
//		return boardList;
//	}
	
	//검색을 받는 메소드(페이징 따로 구
	@Override
	//BooleanBuilder를 사용한 동적쿼리 사용시 에러발생하여 쿼리메소드로 변경하여 검색기능 구현
	public Page<Board> getBoardList(Search search, int page) {
		Pageable pageable = PageRequest.of(page, 10, Sort.Direction.DESC, "seq");
		Page<Board> boardList = null;
		if(search.getSearchCondition().equals("TITLE")) {
		    boardList = boardRepo.findByTitleContainingOrderBySeqDesc(search.getSearchKeyword(), pageable);
		} else if(search.getSearchCondition().equals("CONTENT")) {
			boardList = boardRepo.findByContentContainingOrderBySeqDesc(search.getSearchKeyword(), pageable);
		}
		else boardRepo.findAll(pageable);
		return boardList;
	}

}
