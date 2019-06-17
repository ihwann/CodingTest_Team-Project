package com.stevelee.java.dto;

public class TestmakeSenttype {
	
	String sent_type;
	String sent_type_name;
	
	public TestmakeSenttype() {
		
	}
	
	public TestmakeSenttype(String sent_type, String sent_type_name) {
		super();
		this.sent_type = sent_type;
		this.sent_type_name = sent_type_name;
	}

	public String getSent_type() {
		return sent_type;
	}

	public void setSent_type(String sent_type) {
		this.sent_type = sent_type;
	}

	public String getSent_type_name() {
		return sent_type_name;
	}

	public void setSent_type_name(String sent_type_name) {
		this.sent_type_name = sent_type_name;
	}
	
	

}
