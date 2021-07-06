package com.encore.pms.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encore.pms.dto.Phone;
import com.encore.pms.service.IPhoneService;

@RestController
@RequestMapping("/api")
public class PhoneRestController {

	@Autowired
	private IPhoneService service;
	
	//	1. 모든 폰 정보 리턴
	@GetMapping("phone")
	public ResponseEntity<List<Phone>> getAllBook(){
		try {
			List<Phone> selected = service.select();
			return new ResponseEntity(selected, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	//	2. 특정 num에 해당하는 폰 정보 리턴
	@GetMapping("phone/{num}")
	public ResponseEntity<Phone> getAllBook(@PathVariable String num) throws Exception {
		try {
			Phone phone = new Phone();
			phone.setNum(num);
			Phone selected = service.select(phone);
			return new ResponseEntity(selected, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	//	3. 폰 추가하기
	@PostMapping("phone")
	public ResponseEntity<Phone> insertPhone(@RequestBody Phone phone) throws Exception {
		try {
			System.out.println(phone);
			int result = service.insert(phone);
			return new ResponseEntity(HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	//	4. 폰 수정하기
	@PutMapping("phone") 
	public ResponseEntity<Phone> updatePhone(@RequestBody Phone phone) {
		try {
			System.out.println(phone);
			int result = service.update(phone);
			return new ResponseEntity(HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	//	5. 여러 개의 폰 삭제하기
	@DeleteMapping("phone/{nums}")
	public ResponseEntity<List<Phone>> deletePhone(@PathVariable String[] nums) throws Exception {
		try {
			int result = service.delete(Arrays.asList(nums));
			return new ResponseEntity(HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
}
