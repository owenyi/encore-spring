package com.encore.spring.model;

import org.springframework.web.multipart.MultipartFile;

public class UploadDataVO {

	// form의 input name과 필드의 이름을 일치시켜아 한다.
	private String userName;
	private MultipartFile uploadFile; // uploadFile 이름으로 해야만 업로드한 파일정보를 담을 수 있다.
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
}
