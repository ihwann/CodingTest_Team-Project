
package com.stevelee.java.dao;

import java.util.List;

import com.stevelee.java.dto.GetTestDto;
import com.stevelee.java.dto.TestDto;
import com.stevelee.java.dto.TestmakeCateDto;




public interface TestDao {
   public List<GetTestDto> select_test(TestDto dto);
   public void insert_result(TestDto dto);
   public List<TestDto> get_test_his(TestDto dto);
   public TestDto select_his(int seq);
   public TestmakeCateDto select_test_cate(int test_no);
   public List<Integer> select_test_list(String cate);
   public List<GetTestDto> setInput(int test_no);
   public GetTestDto setOutput(int test_no);
}