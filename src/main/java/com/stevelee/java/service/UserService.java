package com.stevelee.java.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stevelee.java.dao.UserDao;
import com.stevelee.java.dto.regi_UserDto;

@Service
public class UserService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private UserDao userDao;
	
	// 아이디 체크
	public regi_UserDto selectGeneralIdCheck(String email) throws Exception {
		regi_UserDto regiUserDto;
		
		userDao = sqlSession.getMapper(UserDao.class);
		
		regiUserDto = userDao.selectGeneralIdCheck(email);
		
		return regiUserDto;
	}
	
	// 비밀번호 체크
	public boolean selectGeneralPwCheck(Map<String, Object> map) throws Exception {
		boolean result = false;
		
		userDao = sqlSession.getMapper(UserDao.class);
		
		result = userDao.selectGeneralPwCheck(map);
		
		System.out.println(result);
		
		return result;
	}

	public regi_UserDto selectDtoCheck(String email) throws Exception {
		regi_UserDto regiUserDto;
		
		userDao = sqlSession.getMapper(UserDao.class);
		
		regiUserDto = userDao.selectDtoCheck(email);
				
				
		return regiUserDto;
	}

	public void keepLogin(String email, String id, Date sessionLimit) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("userId", email);
		map.put("sessionId", id);
		map.put("next", sessionLimit);
		
		userDao = sqlSession.getMapper(UserDao.class);
		
		
		userDao.keepLogin(map);
	}

	public regi_UserDto checkUserWithSessionKey(String sessionId) throws Exception {
		regi_UserDto regiUserDto;
		
		userDao = sqlSession.getMapper(UserDao.class);
		
		regiUserDto = userDao.selectDtoCheck(sessionId);
		
		return regiUserDto;
	}

	public int cookieUpdate(regi_UserDto regiUserDto) throws Exception{
		int right = 0;
		
		userDao = sqlSession.getMapper(UserDao.class);
		
		right = userDao.cookieUpdate(regiUserDto);
				
		return right;
	}

	public regi_UserDto selectRegi(String email) throws Exception {
		regi_UserDto regiUserDto;
		
		userDao = sqlSession.getMapper(UserDao.class);
		
		regiUserDto = userDao.selectRegi(email);
				
		return regiUserDto;
	}

	
}

