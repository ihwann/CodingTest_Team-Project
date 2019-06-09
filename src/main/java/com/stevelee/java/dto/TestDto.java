package com.stevelee.java.dto;

public class TestDto {
	
	private int seq;
	private int result_no;
	private String result_user;
	private String reslult_code;
	private String result;
	private int result_time;
	private int result_userMemory;
	private int result_runingTime;
	private int reslut_count;
	private int result_error;
	
	public TestDto(){}

	public TestDto(int seq, int result_no, String result_user, String reslult_code, String result, int result_time,
			int result_userMemory, int runing_time, int reslut_count, int result_error) {
		super();
		this.seq = seq;
		this.result_no = result_no;
		this.result_user = result_user;
		this.reslult_code = reslult_code;
		this.result = result;
		this.result_time = result_time;
		this.result_userMemory = result_userMemory;
		this.result_runingTime = runing_time;
		this.reslut_count = reslut_count;
		this.result_error = result_error;
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

	public String getReslult_code() {
		return reslult_code;
	}

	public void setReslult_code(String reslult_code) {
		this.reslult_code = reslult_code;
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

	public int getResult_userMemory() {
		return result_userMemory;
	}

	public void setResult_userMemory(int result_userMemory) {
		this.result_userMemory = result_userMemory;
	}

	public int getRuning_time() {
		return result_runingTime;
	}

	public void setRuning_time(int runing_time) {
		this.result_runingTime = runing_time;
	}

	public int getReslut_count() {
		return reslut_count;
	}

	public void setReslut_count(int reslut_count) {
		this.reslut_count = reslut_count;
	}

	public int getResult_error() {
		return result_error;
	}

	public void setResult_error(int result_error) {
		this.result_error = result_error;
	}


}
