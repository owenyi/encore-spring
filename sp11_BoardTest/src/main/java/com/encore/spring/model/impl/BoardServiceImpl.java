package com.encore.spring.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encore.spring.domain.Board;
import com.encore.spring.model.BoardDAO;
import com.encore.spring.model.BoardService;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO boardDAO;

	@Override
	public void insert(Board vo) throws Exception {
		boardDAO.insert(vo);
	}

	@Override
	public List<Board> selectAll() throws Exception {
		return boardDAO.selectAll();
	}

	@Override
	public Board selectOne(String no) throws Exception {
		return boardDAO.selectOne(no);
	}

}
