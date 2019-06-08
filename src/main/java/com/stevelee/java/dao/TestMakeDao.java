package com.stevelee.java.dao;

import java.util.ArrayList;

import com.stevelee.java.dto.TestmakeCateDto;


//import com.javalec.spring_mybatis.dto.ContentDto;

public interface TestMakeDao {
	
	public ArrayList<TestmakeCateDto> select_testmake_cate(String test_cate);		
	public int insert_testmake_cate(TestmakeCateDto tdto);		

	
	
}
