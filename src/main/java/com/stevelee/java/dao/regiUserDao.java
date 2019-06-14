package com.stevelee.java.dao;

import java.sql.SQLException;

import com.stevelee.java.dto.regi_UserDto;

public interface regiUserDao {
	int insert_regiUser(regi_UserDto udto) throws SQLException; // 유저 회원가입 메서드
	int select_email(String user_eMail) throws SQLException; // 이메일 중복체크 메서드
	int select_nick(String user_nickName) throws SQLException; // 닉네임 중복체크 메서드
}
