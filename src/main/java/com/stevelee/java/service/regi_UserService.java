package com.stevelee.java.service;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stevelee.java.dao.regiUserDao;
import com.stevelee.java.dto.regi_UserDto;

@Service
public class regi_UserService {
	
	@Autowired
	private SqlSessionTemplate userSqlSession;
	private regiUserDao userDao;
	
	// 회원 가입
	public int userRegiService(regi_UserDto udto) throws SQLException {
		int result = 0;
		
		userDao = userSqlSession.getMapper(regiUserDao.class);
		result = userDao.insert_regiUser(udto);
		return result;
	}
	// 중복 이메일 검사
	public int userEmailChk(String user_eMail) throws SQLException{
		int result =0;
		
		userDao = userSqlSession.getMapper(regiUserDao.class);
		result = userDao.select_email(user_eMail);
		return result;
	}
}
