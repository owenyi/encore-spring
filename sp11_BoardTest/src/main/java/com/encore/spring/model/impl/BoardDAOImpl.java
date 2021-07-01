package com.encore.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.Board;
import com.encore.spring.model.BoardDAO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	final String ns = "BoardMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(Board vo) throws Exception {
		sqlSession.insert(ns+"insert", vo);
	}

	@Override
	public List<Board> selectAll() throws Exception {
		List<Board> list = sqlSession.selectList(ns+"selectAll");
		for(Board b : list) {
			System.out.println(b);
		}
		return sqlSession.selectList(ns+"selectAll");
	}

	@Override
	public Board selectOne(String no) throws Exception {
		return sqlSession.selectOne(ns+"selectOne", no);
	}

}
