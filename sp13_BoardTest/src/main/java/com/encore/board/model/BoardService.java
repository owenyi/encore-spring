package com.encore.board.model;

import java.util.List;

import com.encore.board.domain.BoardVO;

public interface BoardService {

	int write(BoardVO vo);
	int update(BoardVO vo);
	int delete(int no);
	List<BoardVO> getBoardList();
	BoardVO showContent(int no);
	int addCount(int no);

}
