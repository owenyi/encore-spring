package com.encore.board.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.board.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public int write(BoardVO vo) {
		int row = boardDAO.write(vo);
		String date = boardDAO.selectByNoForDate(vo.getNo());
		vo.setWriteDate(date); // 화면에 insert 이후 curdate() 보여주기 위해
		return row;
	}
	
	@Override
	public int update(BoardVO vo) {
		return boardDAO.update(vo);
	}
	
	@Override
	public int delete(int no) {
		return boardDAO.delete(no);
	}
	
	@Override
	public List<BoardVO> getBoardList() {
		return boardDAO.getBoardList();
	}
	
	@Override
	public BoardVO showContent(int no) {
		return boardDAO.showContent(no);
	}
	
	@Override
	public int addCount(int no) {
		return boardDAO.addCount(no);
	}

}
