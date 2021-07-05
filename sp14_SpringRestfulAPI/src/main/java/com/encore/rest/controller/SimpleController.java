package com.encore.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encore.rest.dto.Customer;

/*
 * @Controller
 * --> @RequestMapping() 실행 결과로 결과페이지를 리턴
 * 
 * @RestController
 * --> @RequestMapping() 실행 결과로 데이터를 리턴
 * --> @RequestMapping() Rest API 서비스를 사용해서 요청을 한다.
 *     C    -    INSERT :: doPost()
 *     R    -    SELECT :: doGet()
 *     U    -    UPDATE :: doPut()
 *     D    -    DELETE :: doDelete()
 */
@RestController
@RequestMapping("/simple") // 추가하면 --> http://127.0.0.1:8888/rest/simple/hello
public class SimpleController {

	@GetMapping("/hello") // http://127.0.0.1:8888/rest/hello --> 브라우저에 "Hello Restful Service!!" 반환
	public String sayHello() {
		return "Hello Restful Service!!";
	}
	
	// 객체가 리턴되는 경우...JSON으로  변환해서 리턴하기 때문에 라이브러리르 반드시 추가해야 한다.
	// +Class에 getter가 꼭 있어야 에러가 안 난다.
	@GetMapping("/custom")
	public Customer detail() {
		Customer custom = new Customer("아이유", "새벽거리를 걸어요");
		return custom; // JSON Dependency가 없으면 에러가 난다.
	}
	
	@GetMapping("/allCustom")
	public List<Customer> allCustom() {
		List<Customer> list = new ArrayList<Customer>();
		for (int i = 0; i < 3; i++) {
			Customer vo = new Customer();
			vo.setName("아이유, " + i);
			vo.setMessage("새벽길을 걸어요, " + i);
			list.add(vo);
		}
		return list;
	}
	
	@GetMapping("/mapCustom")
	public Map<Integer, Customer> sendCustom() {
		Map<Integer, Customer> map = new HashMap<Integer, Customer>();
		map.put(1, new Customer("아이유1", "새벽거리를 걸어요1"));
		map.put(2, new Customer("아이유2", "새벽거리를 걸어요2"));
		map.put(3, new Customer("아이유3", "새벽거리를 걸어요3"));
		return map;
	}
	
}
