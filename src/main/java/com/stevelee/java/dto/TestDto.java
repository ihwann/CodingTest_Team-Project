package com.stevelee.java.dto;

public class TestDto {
	
	private int seq;
	private int result_no;
	private String result_user;
	private String result_code;
	private String result;
	private int result_time;
	private int result_useMemory;
	private int result_runingTime;
	private int result_count;
	private int result_error;
	private int result_codeLength;
	private char result_del;
	private String result_regi;
	private String cate;
	
	public TestDto(){}

	public TestDto(int seq, int result_no, String result_user, String result_code, String result, int result_time,
			int result_useMemory, int result_runingTime, int result_count, int result_error, int result_codeLength,
			char result_del, String result_regi, String cate) {
		super();
		this.seq = seq;
		this.result_no = result_no;
		this.result_user = result_user;
		this.result_code = result_code;
		this.result = result;
		this.result_time = result_time;
		this.result_useMemory = result_useMemory;
		this.result_runingTime = result_runingTime;
		this.result_count = result_count;
		this.result_error = result_error;
		this.result_codeLength = result_codeLength;
		this.result_del = result_del;
		this.result_regi = result_regi;
		this.cate = cate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getResult_no() {
		return result_no;
	}

	public void setResult_no(int result_no) {
		this.result_no = result_no;
	}

	public String getResult_user() {
		return result_user;
	}

	public void setResult_user(String result_user) {
		this.result_user = result_user;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getResult_time() {
		return result_time;
	}

	public void setResult_time(int result_time) {
		this.result_time = result_time;
	}

	public int getResult_useMemory() {
		return result_useMemory;
	}

	public void setResult_useMemory(int result_useMemory) {
		this.result_useMemory = result_useMemory;
	}

	public int getResult_runingTime() {
		return result_runingTime;
	}

	public void setResult_runingTime(int result_runingTime) {
		this.result_runingTime = result_runingTime;
	}

	public int getResult_count() {
		return result_count;
	}

	public void setResult_count(int result_count) {
		this.result_count = result_count;
	}

	public int getResult_error() {
		return result_error;
	}

	public void setResult_error(int result_error) {
		this.result_error = result_error;
	}

	public int getResult_codeLength() {
		return result_codeLength;
	}

	public void setResult_codeLength(int result_codeLength) {
		this.result_codeLength = result_codeLength;
	}

	public char getResult_del() {
		return result_del;
	}

	public void setResult_del(char result_del) {
		this.result_del = result_del;
	}

	public String getResult_regi() {
		return result_regi;
	}

	public void setResult_regi(String result_regi) {
		this.result_regi = result_regi;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

}
