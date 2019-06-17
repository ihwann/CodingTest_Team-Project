package com.stevelee.java.dto;

public class JobDto {

	private int jobs_num;
	private String jobs_date;
	private String jobs_user;
	private String jobs_title;
	private String jobs_main_lang;
	private String jobs_field;
	private String jobs_loc;
	private String jobs_content;
	
	
	public JobDto() {
		
	}


	public JobDto(int jobs_num, String jobs_date, String jobs_user, String jobs_title, String jobs_main_lang,
			String jobs_field, String jobs_loc, String jobs_content) {
		super();
		this.jobs_num = jobs_num;
		this.jobs_date = jobs_date;
		this.jobs_user = jobs_user;
		this.jobs_title = jobs_title;
		this.jobs_main_lang = jobs_main_lang;
		this.jobs_field = jobs_field;
		this.jobs_loc = jobs_loc;
		this.jobs_content = jobs_content;
	}


	public int getJobs_num() {
		return jobs_num;
	}


	public void setJobs_num(int jobs_num) {
		this.jobs_num = jobs_num;
	}


	public String getJobs_date() {
		return jobs_date;
	}


	public void setJobs_date(String jobs_date) {
		this.jobs_date = jobs_date;
	}


	public String getJobs_user() {
		return jobs_user;
	}


	public void setJobs_user(String jobs_user) {
		this.jobs_user = jobs_user;
	}


	public String getJobs_title() {
		return jobs_title;
	}


	public void setJobs_title(String jobs_title) {
		this.jobs_title = jobs_title;
	}


	public String getJobs_main_lang() {
		return jobs_main_lang;
	}


	public void setJobs_main_lang(String jobs_main_lang) {
		this.jobs_main_lang = jobs_main_lang;
	}


	public String getJobs_field() {
		return jobs_field;
	}


	public void setJobs_field(String jobs_field) {
		this.jobs_field = jobs_field;
	}


	public String getJobs_loc() {
		return jobs_loc;
	}


	public void setJobs_loc(String jobs_loc) {
		this.jobs_loc = jobs_loc;
	}


	public String getJobs_content() {
		return jobs_content;
	}


	public void setJobs_content(String jobs_content) {
		this.jobs_content = jobs_content;
	}
	
	
	
}
