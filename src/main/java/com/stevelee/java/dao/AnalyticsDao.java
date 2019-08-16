package com.stevelee.java.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.stevelee.java.dto.TestDto;

public interface AnalyticsDao {

	public ArrayList<Map<String, Object>> select_analytics_result(String email);

	public ArrayList<Map<String, Object>> select_analytics_cate_succ_result(String email);
}
