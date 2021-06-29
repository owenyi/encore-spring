package com.encore.spring.model.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.spring.domain.UserVO;
import com.encore.spring.model.UserDAO;
import com.encore.spring.model.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserVO login(HashMap map) throws Exception {
		return userDAO.login(map);
	}

}
