package com.pnu.dao;

import java.util.Map;

import com.pnu.domain.BoardVO;

public interface BoardDAO {
	
	
	Map<String, Object> getBoards();
	
	Map<String, Object> getBoard(int seq);
	
	Map<String, Object> addBoard(BoardVO boardVO);
	
	Map<String, Object> updateBoard(BoardVO boardVO);
	
	Map<String, Object> deleteBoard(int seq);
}
