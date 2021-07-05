package com.encore.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encore.pms.dao.IPhoneDAO;
import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;

@Service
public class PhoneServiceImpl implements IPhoneService {

	@Autowired
	private IPhoneDAO iPhoneDAO;
	
	@Override
	@Transactional
	public int insert(Phone phone) {
		return iPhoneDAO.insert(phone);
	}

	@Override
	@Transactional
	public int delete(String[] nums) {
		return iPhoneDAO.delete(nums);
	}

	@Override
	public Phone select(Phone phone) {
		return iPhoneDAO.select(phone);
	}

	@Override
	public List<Phone> select() {
		return iPhoneDAO.select();
	}

	@Override
	public UserInfo select(UserInfo user) {
		return iPhoneDAO.select(user);
	}

}