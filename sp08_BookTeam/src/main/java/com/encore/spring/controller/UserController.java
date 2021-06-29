package com.encore.spring.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.UserVO;
import com.encore.spring.model.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, String userId, String userPass) throws Exception {
		HashMap map = new HashMap();
		map.put("userId", userId);
		map.put("password", userPass);
		
		UserVO rvo = userService.login(map);
		
		if(rvo != null) {//로그인 성공했으면...
			HttpSession session = request.getSession();
			session.setAttribute("mvo", rvo);
		}
		
		return new ModelAndView("login_result");
	}
	
}
