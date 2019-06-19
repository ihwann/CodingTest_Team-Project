package com.stevelee.java.dao;

import java.util.List;

import com.stevelee.java.dto.GetTestDto;
import com.stevelee.java.dto.TestDto;




public interface TestDao {
	public List<GetTestDto> select_test(TestDto dto);
	public void insert_result(TestDto dto);
	public List<TestDto> get_test_his(TestDto dto);
	public TestDto select_his(int seq);
	public List<Integer> select_test_list(String cate);
}
