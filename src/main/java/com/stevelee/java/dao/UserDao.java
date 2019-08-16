package com.stevelee.java.dao;

import java.sql.Date;
import java.util.Map;

import com.stevelee.java.dto.regi_UserDto;

public interface UserDao {

	regi_UserDto selectGeneralIdCheck(String email) throws Exception;

	boolean selectGeneralPwCheck(Map<String, Object> map) throws Exception;

	regi_UserDto selectDtoCheck(String email) throws Exception;

	void keepLogin(String email, String id, Date sessionLimit) throws Exception;
	
	regi_UserDto checkUserWithSessionKey(String sessionId) throws Exception;

	int cookieUpdate(regi_UserDto regiUserDto) throws Exception;

	regi_UserDto selectRegi(String email) throws Exception;

	void keepLogin(Map<String, Object> map);

	
}
