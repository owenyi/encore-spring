package com.encore.pms.service;

import java.util.List;

import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;

public interface IPhoneService {

	// DAO와 똑같이 만듦
	int insert(Phone phone);
	int update(Phone phone);
	int delete(List<String> nums); // 나중에 이 부분을 수정할 수도 있다.
	Phone select(Phone phone);
	List<Phone> select();
	UserInfo select(UserInfo user);
	
}
