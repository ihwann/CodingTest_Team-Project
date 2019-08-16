package com.stevelee.java.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stevelee.java.dao.JobDao;
import com.stevelee.java.dao.ReviewDao;
import com.stevelee.java.dto.JobDto;

@Service
public class JobListService {

	
	@Autowired
	private SqlSession jobSqlSession;
	private JobDao jobDao;
	
	public ArrayList<JobDto> select_all_job() throws SQLException{
		
		jobDao = jobSqlSession.getMapper(JobDao.class);
		
		return jobDao.select_all_job();
	}

	
	public ArrayList<String> select_all_job_main_lang() throws SQLException{
		
		jobDao = jobSqlSession.getMapper(JobDao.class);
		
		return jobDao.select_all_job_main_lang();
	}
	
	public ArrayList<String> select_all_job_field() throws SQLException{
		
		jobDao = jobSqlSession.getMapper(JobDao.class);
		
		return jobDao.select_all_job_field();
	}
	
	public ArrayList<String> select_all_job_loc() throws SQLException{
		
		jobDao = jobSqlSession.getMapper(JobDao.class);
		
		return jobDao.select_all_job_loc();
	}
	
	public JobDto select_job(int id) throws SQLException{
		
		jobDao = jobSqlSession.getMapper(JobDao.class);
		
		return jobDao.select_job(id);
	}
	
	public int insert_job(JobDto job) throws SQLException {
		int result = 0;
		String temp_id = "tempId";
		job.setJob_user(temp_id);
		
		jobDao = jobSqlSession.getMapper(JobDao.class);
		
		result = jobDao.insert_job(job);
		
		return result;
		
	}
	
	public int delete_job(int id) throws SQLException{
		
		jobDao = jobSqlSession.getMapper(JobDao.class);
		
		return jobDao.delete_job(id);
	}
}
