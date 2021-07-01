package com.encore.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.encore.spring.domain.Person;

@Controller
public class AjaxController {

	@RequestMapping("/") // ContextPath로 요청을 한다면...http://127.0.0.1:8888/spring
	public String index() { // 자유도 높다...ModelAndView 말고 String 리턴...결과 페이지를 알려준다.
		System.out.println("'/'...index() calling...");
		return "redirect:index.jsp";
	}
	
	@RequestMapping("synchro")
	public String synchro(Model model) {
		model.addAttribute("info", "와~~~ 동기통신!!"); // 기본이 request 영역?...session scope로 바꿀 수 있나?
		System.out.println("동기통신...synchro() calling...");
		
		return "synchro_result";
	}
	
	@RequestMapping("asynch")
	public String asynch(Model model) {
		System.out.println("비동기 통신...asynch() calling...");
		// 비즈니르 로직 수행된 결과로...Service 호출 결과...person 객체가 리턴됐다고 가정하자.
		model.addAttribute("person", new Person("아이유", "서초동"));
		return "JsonView"; // 비동기 출력(결과) 페이지 x...BeanNameViewResolver (like...file download)
	}
	
}
