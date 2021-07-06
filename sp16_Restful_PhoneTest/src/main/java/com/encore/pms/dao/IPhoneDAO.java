package com.encore.pms.dao;

import java.util.List;

import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;

public interface IPhoneDAO {

	int insert(Phone phone);
	int update(Phone phone);
	int delete(List<String> nums);
	// 동적 쿼리에 대해서 일일이 대응하는 함수명을 만드는 것 보다는 Overloading 기법을 활용하자
	Phone select(Phone phone);
	List<Phone> select();
	UserInfo select(UserInfo user);
	
}