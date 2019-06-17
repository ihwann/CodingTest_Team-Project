package com.stevelee.java.dto;

public class TestviewListDto {
	
	int test_no;
	String test_cate;
	String test_type;
	String test_title;
	
	
	public TestviewListDto() {
		
	}
	
	public TestviewListDto(int test_no, String test_cate, String test_type, String test_title) {
		super();
		this.test_no = test_no;
		this.test_cate = test_cate;
		this.test_type = test_type;
		this.test_title = test_title;
	}

	public int getTest_no() {
		return test_no;
	}

	public void setTest_no(int test_no) {
		this.test_no = test_no;
	}

	public String getTest_cate() {
		return test_cate;
	}

	public void setTest_cate(String test_cate) {
		this.test_cate = test_cate;
	}

	public String getTest_type() {
		return test_type;
	}

	public void setTest_type(String test_type) {
		this.test_type = test_type;
	}

	public String getTest_title() {
		return test_title;
	}

	public void setTest_title(String test_title) {
		this.test_title = test_title;
	}
	
	
	

}
