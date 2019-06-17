package com.stevelee.java.dao;

import java.util.List;

import com.stevelee.java.dto.GetTestDto;
import com.stevelee.java.dto.TestDto;




public interface TestDao {
	public  List<GetTestDto> select_test(int test_no);
	public void insert_result(TestDto dto);
}
