package com.encore.spring.model;

import java.util.List;

import com.encore.spring.domain.Myproduct;

public interface MyproductDAO {
	int addMyproduct(Myproduct myproduct) throws Exception;
	List<Myproduct> getMyproductList(String word) throws Exception;
	Myproduct getMyproduct(Integer id) throws Exception;
}