package com.encore.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Myproduct;
import com.encore.spring.model.MyproductCatalog;

@Controller
public class MyproductController {

	@Autowired
	private MyproductCatalog myproductCatalog;
	
//	@RequestMapping("myProduct.do")
//	public ModelAndView myProduct(String name, String maker, int price) throws Exception {
//		Myproduct product = new Myproduct(name, maker, price);
//		myproductCatalog.addMyproduct(product);
//		return new ModelAndView("WEB-INF/views/myProductView.jsp");
//	}
	
//	@RequestMapping(value="myProduct.do", method=RequestMethod.POST)
	@RequestMapping("myProduct.do")
	public ModelAndView myProduct(Myproduct pvo) throws Exception {
		System.out.println(pvo.getId());
		myproductCatalog.addMyproduct(pvo);
		System.out.println(pvo.getId()); // add 갔다 오면 id auto_increment 값이 나올 거다.
		return new ModelAndView("WEB-INF/views/myProductView.jsp");
	}
	
	@RequestMapping("mySearch.do")
	public ModelAndView mySearch(String word) throws Exception {
		if (word.matches("[0-9]+")) {
			Myproduct myproduct = myproductCatalog.getMyproduct(Integer.parseInt(word));
			return new ModelAndView("WEB-INF/views/mySearchView.jsp", "myproduct", myproduct);
		}
		else {
			List<Myproduct> list = myproductCatalog.getMyproductList(word);
			return new ModelAndView("WEB-INF/views/mySearchListView.jsp", "list", list);
		}
	}
	
}
