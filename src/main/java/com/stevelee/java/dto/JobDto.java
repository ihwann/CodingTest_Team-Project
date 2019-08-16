package com.stevelee.java.dto;

public class JobDto {
		
	private int job_num;
	private String job_date;
	private String job_user;
	private String job_title;
	private String job_main_lang;
	private String job_field;
	private String job_loc;
	private String job_smsi;
	private String job_content;
	
	
	public JobDto() {
		
	}


	public JobDto(int job_num, String job_date, String job_smsi, String job_user, String job_title, String job_main_lang,
			String job_field, String job_loc, String job_content) {
		super();
		this.job_num = job_num;
		this.job_date = job_date;
		this.job_smsi = job_smsi;
		this.job_user = job_user;
		this.job_title = job_title;
		this.job_main_lang = job_main_lang;
		this.job_field = job_field;
		this.job_loc = job_loc;
		this.job_content = job_content;
	}


	
	public String getJob_smsi() {
		return job_smsi;
	}


	public void setJob_smsi(String job_smsi) {
		this.job_smsi = job_smsi;
	}


	public int getJob_num() {
		return job_num;
	}


	public void setJob_num(int job_num) {
		this.job_num = job_num;
	}


	public String getJob_date() {
		return job_date;
	}


	public void setJob_date(String job_date) {
		this.job_date = job_date;
	}


	public String getJob_user() {
		return job_user;
	}


	public void setJob_user(String job_user) {
		this.job_user = job_user;
	}


	public String getJob_title() {
		return job_title;
	}


	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}


	public String getJob_main_lang() {
		return job_main_lang;
	}


	public void setJob_main_lang(String job_main_lang) {
		this.job_main_lang = job_main_lang;
	}


	public String getJob_field() {
		return job_field;
	}


	public void setJob_field(String job_field) {
		this.job_field = job_field;
	}


	public String getJob_loc() {
		return job_loc;
	}


	public void setJob_loc(String job_loc) {
		this.job_loc = job_loc;
	}


	public String getJob_content() {
		return job_content;
	}


	public void setJob_content(String job_content) {
		this.job_content = job_content;
	}


	@Override
	public String toString() {
		return "JobDto [job_num=" + job_num + ", job_date=" + job_date + ", job_user=" + job_user + ", job_title="
				+ job_title + ", job_main_lang=" + job_main_lang + ", job_field=" + job_field + ", job_loc=" + job_loc
				+ ", job_content=" + job_content + "]";
	}
	
	
	
}
