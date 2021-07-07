package com.encore.boot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 프로젝트명+Application.java 파일이 만들어진다.
// 이 파일을 실행해야만 SpringBoot 서버가 가동된다.
@SpringBootApplication
public class Spboot17Simple01Application {

	public static void main(String[] args) {
		SpringApplication.run(Spboot17Simple01Application.class, args);
	}

}
