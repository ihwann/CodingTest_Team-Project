package com.stevelee.java.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stevelee.java.dao.ReviewDao;
import com.stevelee.java.dto.ReviewDto;

@Service
public class ReviewListService {

	@Autowired
	private SqlSession reviewSqlSession;
	private ReviewDao reviewDao;

	
	public ArrayList<ReviewDto> select_all_review() throws SQLException{
		
		reviewDao = reviewSqlSession.getMapper(ReviewDao.class);
		
		return reviewDao.select_all_review();
	}

	
	public ArrayList<String> select_all_review_comp() throws SQLException{
		
		reviewDao = reviewSqlSession.getMapper(ReviewDao.class);
		
		return reviewDao.select_all_review_comp();
	}
	
	
	public ReviewDto select_review(int id) throws SQLException{
		
		reviewDao = reviewSqlSession.getMapper(ReviewDao.class);
		
		return reviewDao.select_review(id);
	}
	
	public int insert_review(ReviewDto review) throws SQLException {
		int result = 0;
		String temp_id = "tempId";
		review.setReview_user(temp_id);
		
		reviewDao = reviewSqlSession.getMapper(ReviewDao.class);
		
		result = reviewDao.insert_review(review);
		
		return result;
		
		
	}
	
	
}
