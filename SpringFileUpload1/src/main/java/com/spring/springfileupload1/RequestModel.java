package com.spring.springfileupload1;

import org.springframework.web.multipart.MultipartFile;

public class RequestModel {
	private String name;
	private MultipartFile file[]; // 업로드할 파일리스트가 저장됨. 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile[] getFile() {
		return file;
	}
	public void setFile(MultipartFile[] file) {
		this.file = file;
	}
	
	
}
