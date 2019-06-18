package com.stevelee.java.service;

import org.springframework.stereotype.Service;

@Service
public class regi_randomNum {
	public String create_randomNum() {
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<8; i++) {
			int num = (int) (Math.random()*10);
			sb.append(num);
		}
		return sb.toString();
	}
}
