package com.encore.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.encore.emp.domain.EmployeeDto;
import com.encore.emp.service.EmpService;

@Controller // 수행 결과로 결과 페이지 리턴
public class SimpleController {

	@Autowired
	private EmpService service;
	
	@GetMapping("index")
	public String index(Model model) {
		model.addAttribute("data", "Boot....Simple Controller");
		return "result";
	}
	
	@GetMapping("emps")
	public String allEmps(Model model) throws Exception {
		List<EmployeeDto> list = service.findAllEmployees();
		model.addAttribute("list", list.toString());
		return "list";
	}
	
}
