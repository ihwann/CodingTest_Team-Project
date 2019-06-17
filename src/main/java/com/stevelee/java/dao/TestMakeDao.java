package com.stevelee.java.dao;

import java.util.ArrayList;

import com.stevelee.java.dto.TestmakeCateDto;
import com.stevelee.java.dto.TestmakeContentsDto;
import com.stevelee.java.dto.TestmakeSenttype;
import com.stevelee.java.dto.TestmakeTitleDto;
import com.stevelee.java.dto.TestviewListDto;


//import com.javalec.spring_mybatis.dto.ContentDto;

public interface TestMakeDao {
	
	public ArrayList<TestmakeCateDto> select_testmake_cate(String test_cate);		
	public ArrayList<String> selectlist_testmake_cate();		
	public ArrayList<TestmakeCateDto> selectlist_testmake_cate2();		
	public ArrayList<TestmakeCateDto> selectlist_testmake_type();		
	public ArrayList<TestmakeCateDto> selectlist_testmake_type_param(String test_cate);		
	
	public ArrayList<TestmakeSenttype> selectlist_testmake_senttype();	
	
	public int selectmax_testmake_title();	
	public int insert_testmake_title(TestmakeTitleDto tdto);	
	public int insert_testmake_contents(TestmakeContentsDto tdto);	
	
	public ArrayList<TestmakeContentsDto> selectlist_testmake_contents(int test_no);		
	public ArrayList<TestviewListDto> selectlist_testview_list(int start, int pagecnt);		
	public int selectlist_testview_list_cnt();		
	
	public int insert_testmake_cate(TestmakeCateDto tdto);		

	
	
}
