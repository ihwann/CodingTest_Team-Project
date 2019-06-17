package com.stevelee.java.dto;

public class TestmakeContentsDto {

	int test_no;
	String sent_type;
	int sent_no;
	String sent_cont;
	
	public TestmakeContentsDto() {
		
	}

	public TestmakeContentsDto(int test_no, String sent_type, int sent_no, String sent_cont) {
		super();
		this.test_no = test_no;
		this.sent_type = sent_type;
		this.sent_no = sent_no;
		this.sent_cont = sent_cont;
	}

	public int getTest_no() {
		return test_no;
	}

	public void setTest_no(int test_no) {
		this.test_no = test_no;
	}

	public String getSent_type() {
		return sent_type;
	}

	public void setSent_type(String sent_type) {
		this.sent_type = sent_type;
	}

	public int getSent_no() {
		return sent_no;
	}

	public void setSent_no(int sent_no) {
		this.sent_no = sent_no;
	}

	public String getSent_cont() {
		return sent_cont;
	}

	public void setSent_cont(String sent_cont) {
		this.sent_cont = sent_cont;
	}
	
	
	

}
