package com.stevelee.java.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.stevelee.java.dto.JobDto;

public interface JobDao {

	ArrayList<JobDto> select_all_job() throws SQLException; //전체 review 가져와 화면에 뿌리기
	int select_all_main_lang() throws SQLException; //회사 이름 다 가져오기(셀렉트박스)
	int select_all_field() throws SQLException; //분야  이름 다 가져오기(셀렉트박스)
	int select_all_loc() throws SQLException; //지역  이름 다 가져오기(셀렉트박스)

}
