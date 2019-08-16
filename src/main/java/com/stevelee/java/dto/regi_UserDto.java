package com.stevelee.java.dto;

/**
 * @author Owner
 *
 */
public class regi_UserDto  {
	private String user_eMail;
	private String user_pw;
	private String user_nickName;
	private String sessionkey;
	private int user_check;

	
	public regi_UserDto() {
	}

	public regi_UserDto(String user_eMail, String user_pw, String user_nickName, String sessionkey, int user_check) {
		super();
		this.user_eMail = user_eMail;
		this.user_pw = user_pw;
		this.user_nickName = user_nickName;
		this.sessionkey = sessionkey;
		this.user_check = user_check;
		
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

	public String getSessionkey() {
		return sessionkey;
	}

	public void setSessionkey(String sessionkey) {
		this.sessionkey = sessionkey;
	}

	public int getUser_check() {
		return user_check;
	}

	public void setUser_check(int user_check) {
		this.user_check = user_check;
	}


	
}
