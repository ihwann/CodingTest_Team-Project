package com.stevelee.java.dto;

public class regi_UserDto {
	private String user_eMail;
	private String user_pw;
	private String user_nickName;
	//private boolean user_regiKaKao;
	// String user_date;

	public regi_UserDto() {
	}

	public regi_UserDto(String user_eMail, String user_pw, String user_nickName) {
		super();
		this.user_eMail = user_eMail;
		this.user_pw = user_pw;
		this.user_nickName = user_nickName;
	}

	public String getUser_eMail() {
		return user_eMail;
	}

	public void setUser_eMail(String user_eMail) {
		this.user_eMail = user_eMail;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_nickName() {
		return user_nickName;
	}

	public void setUser_nickName(String user_nickName) {
		this.user_nickName = user_nickName;
	}

}
