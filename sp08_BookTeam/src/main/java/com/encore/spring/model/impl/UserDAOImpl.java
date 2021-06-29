package com.encore.spring.model.impl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.UserVO;
import com.encore.spring.model.UserDAO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NS = "UserMapper.";
	
	@Override
	public UserVO login(HashMap map) throws Exception {
		return sqlSession.selectOne(NS+"login", map);
	}

}
