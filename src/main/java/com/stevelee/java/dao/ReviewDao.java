package com.stevelee.java.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.stevelee.java.dto.ReviewDto;

public interface ReviewDao {
	ArrayList<ReviewDto> select_all_review() throws SQLException; //전체 review 가져와 화면에 뿌리기
	ArrayList<String> select_all_review_comp() throws SQLException; //회사 이름 다 가져오기(셀렉트박스)  
	ReviewDto select_review(int id) throws SQLException;// 특정 리뷰 가져오기 
	int insert_review(ReviewDto review) throws SQLException;//리뷰 업로드 
}
