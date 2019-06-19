package com.stevelee.java.dto;

public class TestDto {
	
	private int test_result_seq;
	private int test_result_no;
	private String test_result_user;
	private String test_result_code;
	private String test_result;
	private int test_result_time;
	private int test_result_useMemory;
	private int test_result_runingTime;
	private int test_result_count;
	private int test_result_error;
	private int test_result_codeLength;
	private char test_result_del;
	private String test_result_regi;
	private String cate;
	
	public TestDto(){}

	public TestDto(int test_result_seq, int test_result_no, String test_result_user, String test_result_code,
			String test_result, int test_result_time, int test_result_useMemory, int test_result_runingTime,
			int test_result_count, int test_result_error, int test_result_codeLength, char test_result_del,
			String test_result_regi, String cate) {
		super();
		this.test_result_seq = test_result_seq;
		this.test_result_no = test_result_no;
		this.test_result_user = test_result_user;
		this.test_result_code = test_result_code;
		this.test_result = test_result;
		this.test_result_time = test_result_time;
		this.test_result_useMemory = test_result_useMemory;
		this.test_result_runingTime = test_result_runingTime;
		this.test_result_count = test_result_count;
		this.test_result_error = test_result_error;
		this.test_result_codeLength = test_result_codeLength;
		this.test_result_del = test_result_del;
		this.test_result_regi = test_result_regi;
		this.cate = cate;
	}

	public int getTest_result_seq() {
		return test_result_seq;
	}

	public void setTest_result_seq(int test_result_seq) {
		this.test_result_seq = test_result_seq;
	}

	public int getTest_result_no() {
		return test_result_no;
	}

	public void setTest_result_no(int test_result_no) {
		this.test_result_no = test_result_no;
	}

	public String getTest_result_user() {
		return test_result_user;
	}

	public void setTest_result_user(String test_result_user) {
		this.test_result_user = test_result_user;
	}

	public String getTest_result_code() {
		return test_result_code;
	}

	public void setTest_result_code(String test_result_code) {
		this.test_result_code = test_result_code;
	}

	public String getTest_result() {
		return test_result;
	}

	public void setTest_result(String test_result) {
		this.test_result = test_result;
	}

	public int getTest_result_time() {
		return test_result_time;
	}

	public void setTest_result_time(int test_result_time) {
		this.test_result_time = test_result_time;
	}

	public int getTest_result_useMemory() {
		return test_result_useMemory;
	}

	public void setTest_result_useMemory(int test_result_useMemory) {
		this.test_result_useMemory = test_result_useMemory;
	}

	public int getTest_result_runingTime() {
		return test_result_runingTime;
	}

	public void setTest_result_runingTime(int test_result_runingTime) {
		this.test_result_runingTime = test_result_runingTime;
	}

	public int getTest_result_count() {
		return test_result_count;
	}

	public void setTest_result_count(int test_result_count) {
		this.test_result_count = test_result_count;
	}

	public int getTest_result_error() {
		return test_result_error;
	}

	public void setTest_result_error(int test_result_error) {
		this.test_result_error = test_result_error;
	}

	public int getTest_result_codeLength() {
		return test_result_codeLength;
	}

	public void setTest_result_codeLength(int test_result_codeLength) {
		this.test_result_codeLength = test_result_codeLength;
	}

	public char getTest_result_del() {
		return test_result_del;
	}

	public void setTest_result_del(char test_result_del) {
		this.test_result_del = test_result_del;
	}

	public String getTest_result_regi() {
		return test_result_regi;
	}

	public void setTest_result_regi(String test_result_regi) {
		this.test_result_regi = test_result_regi;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	@Override
	public String toString() {
		return "TestDto [test_result_seq=" + test_result_seq + ", test_result_no=" + test_result_no
				+ ", test_result_user=" + test_result_user + ", test_result_code=" + test_result_code + ", test_result="
				+ test_result + ", test_result_time=" + test_result_time + ", test_result_useMemory="
				+ test_result_useMemory + ", test_result_runingTime=" + test_result_runingTime + ", test_result_count="
				+ test_result_count + ", test_result_error=" + test_result_error + ", test_result_codeLength="
				+ test_result_codeLength + ", test_result_del=" + test_result_del + ", test_result_regi="
				+ test_result_regi + ", cate=" + cate + "]";
	}

}
