package com.stevelee.java.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stevelee.java.dao.ReviewDao;
import com.stevelee.java.dto.ReviewDto;

@Service
public class ReviewListService implements ReviewDao{

	@Autowired
	private SqlSession reviewSqlSession;
	
	@Autowired
	private ReviewDao reviewDao;

	@Override
	public ArrayList<ReviewDto> select_all_review() throws SQLException, Exception {
		
		reviewDao = reviewSqlSession.getMapper(ReviewDao.class);
		
		return reviewDao.select_all_review();
	}

	@Override
	public ArrayList<String> select_all_review_comp() throws SQLException, Exception {
		
		reviewDao = reviewSqlSession.getMapper(ReviewDao.class);
		
		return reviewDao.select_all_review_comp();
	}
	
	
	
}
