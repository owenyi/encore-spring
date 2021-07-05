package com.encore.pms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;
import com.encore.pms.service.IPhoneService;

@Controller
public class MainController {	
	
	@Autowired
	private IPhoneService iPhoneService;
	
	@GetMapping("login.do")
	public String getLoginForm() {
		return "Login";
	}
	
	@PostMapping("login.do")
	public String doLogin(UserInfo user, Model model, HttpSession session) {
		try {
			UserInfo selected = iPhoneService.select(user);
			if (selected != null) { // id, pw 일치하는 계정으로 로그인
				session.setAttribute("loginUser", selected);
				
				// 모든 폰이 검색된 결과 페이지로 이동
//				return "redirect:index.jsp"; // redirect 안 하면 에러남
				return "index";
			} else { // id, pw 불일치
				return "Login"; // Login.jsp 이동...다시 로그인 시도
			}
		} catch(Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 로그인 실패");
			model.addAttribute("message", "문제 내용 - 로그인 중 오류가 발생했습니다.");
			return "Error";
		}
	}
	
	@GetMapping("searchPhone.do") // 전체 폰 목록을 보여주는 기능...결과 페이지는 PhoneList.jsp
	public String doList(Model model) {
		try {
			List<Phone> list = iPhoneService.select();
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 리스트");
			model.addAttribute("phones", list);
			return "PhoneList";
		} catch(Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 목록 조회 에러");
			model.addAttribute("message", "문제 내용 - 핸드폰 목록 조회 중 오류가 발생했습니다.");
			return "Error";
		}
	}
	
	@GetMapping("regPhone.do")
	public String getRegPhone(Model model) {
		model.addAttribute("title", "핸드폰 관리 - 핸드폰 등록폼");
		return "PhoneReg";
	}
	
	@PostMapping("savePhone.do")
	public String doRegPhone(Phone phone, Model model) {
		try {
			iPhoneService.insert(phone);
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 등록 성공");
			return "Result";
		} catch(Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 등록 에러");
			model.addAttribute("message", "문제 내용 - 핸드폰 등록 중 오류가 발생했습니다.");
			return "Error";
		}
	}
	
	@GetMapping("detail.do")
	public String doList(Phone phone, Model model) {
		try {
			Phone selected = iPhoneService.select(phone);
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 상세 조회");
			model.addAttribute("phone", selected);
			return "PhoneView";
		} catch(Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 상세 조회 에러");
			model.addAttribute("message", "문제 내용 - 핸드폰 상세 조회 중 오류가 발생했습니다.");
			return "Error";
		}
	}
	
	@GetMapping("logout.do")
	public String doLogout(Model model, HttpSession session) {
		try {
			session.invalidate();
			return "index";
		} catch(Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 로그인 실패");
			model.addAttribute("message", "문제 내용 - 로그아웃 중 오류가 발생했습니다.");
			return "Error";
		}
	}
	
	@PostMapping("delPhone.do")
	public String doDelPhone(String[] nums) {
		try {
			System.out.println(iPhoneService.delete(nums));
			return "JsonView";
		} catch(Exception e) {
			return "JsonView";
		}
	}
	
}