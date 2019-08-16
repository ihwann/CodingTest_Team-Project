package com.stevelee.java.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.stevelee.java.dto.JobDto;
import com.stevelee.java.dto.ReviewDto;

public interface JobDao {

	ArrayList<JobDto> select_all_job() throws SQLException; //전체 review 가져와 화면에 뿌리기
	ArrayList<String> select_all_job_main_lang() throws SQLException; //회사 이름 다 가져오기(셀렉트박스)
	ArrayList<String> select_all_job_field() throws SQLException; //분야  이름 다 가져오기(셀렉트박스)
	ArrayList<String> select_all_job_loc() throws SQLException; //지역  이름 다 가져오기(셀렉트박스)
	JobDto select_job(int id) throws SQLException;//특정 job 불러오기 
	int insert_job(JobDto job) throws SQLException;//Job 등록 
	int delete_job(int id) throws SQLException;//특정 job 삭제하기 
	ArrayList<JobDto> select_search_job(Map<String, String> map) throws SQLException;//search 기능
	
}
