package com.stevelee.java.dao;

import java.util.ArrayList;

import com.stevelee.java.dto.TestDto;
import com.stevelee.java.dto.TestmakeCateDto;
import com.stevelee.java.dto.TestmakeContentsDto;



public interface TestDao {
	public void insert_result(TestDto dto);		
	public TestmakeContentsDto select_test(int no);	

}
