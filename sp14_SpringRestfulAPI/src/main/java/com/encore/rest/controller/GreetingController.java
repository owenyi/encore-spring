package com.encore.rest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.encore.rest.dto.Greeting;

@RestController
public class GreetingController {
	
	// 필드 추가
	private final AtomicLong counter = new AtomicLong();

	// http://127.0.0.1:8888/rest/greet
	@GetMapping("/greet")
	public Greeting sayGreet() {
		return new Greeting(314L, "Restful API");
	}
	
	// http://127.0.0.1:8888/rest/greet/33
	// @PahtVariable은 단순 파라미터 값을 URL 경로에 포함시키는 방법이다.
	@GetMapping("/greet/{num}")
	public String showSample(@PathVariable int num) {
		return "Hello Restful API case number..." + num;
	}

	// http://127.0.0.1:8888/rest/greet2?msg=
	@GetMapping("/greet2")
	public Greeting sayGreet(@RequestParam(
			value="msg", 
			required=false, // required=false로 두면 파라미터 없이 요청할 수 있지만 defaultValue를 넣어줘야 함
			defaultValue="world") String name) {
		return new Greeting(counter.incrementAndGet(), name);
	}
	
}
