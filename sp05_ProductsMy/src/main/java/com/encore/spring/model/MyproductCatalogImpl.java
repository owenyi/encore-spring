package com.encore.spring.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.spring.domain.Myproduct;

@Service
public class MyproductCatalogImpl implements MyproductCatalog {

	@Autowired
	private MyproductDAO myproductDAO;
	
	@Override
	public void addMyproduct(Myproduct myproduct) throws Exception {
		int result = myproductDAO.addMyproduct(myproduct);
		if (result == 1) System.out.println("상품을 추가했습니다.");
	}

	@Override
	public List<Myproduct> getMyproductList(String word) throws Exception {
		return myproductDAO.getMyproductList(word);
	}

	@Override
	public Myproduct getMyproduct(Integer id) throws Exception {
		return myproductDAO.getMyproduct(id);
	}

}
