package com.stevelee.java.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AnalyticsController {
	
	@RequestMapping(value = "/overview", method = RequestMethod.GET)
	public String overview(ModelMap model) throws Exception {
		System.out.println("overview");
		return "analy/overview";
	}
}
