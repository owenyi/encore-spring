package com.encore.spring.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.Myproduct;

@Repository
public class MyproductDAOImpl implements MyproductDAO {

	@Autowired
	private SqlSession sqlSession;
	private static final String NS = "MyproductMapper.";
	
	@Override
	public int addMyproduct(Myproduct myproduct) throws Exception {
		return sqlSession.insert(NS+"addMyproduct", myproduct);
	}

	@Override
	public List<Myproduct> getMyproductList(String word) throws Exception {
		return sqlSession.selectList(NS+"getMyproductList", word);
	}

	@Override
	public Myproduct getMyproduct(Integer id) throws Exception {
		return sqlSession.selectOne(NS+"getMyproduct", id);
	}

}
