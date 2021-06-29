package com.encore.spring.model;

import java.util.HashMap;

import com.encore.spring.domain.UserVO;

public interface UserDAO {
	UserVO login(HashMap map) throws Exception;
}
