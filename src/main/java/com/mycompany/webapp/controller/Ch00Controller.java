package com.mycompany.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch00")
public class Ch00Controller {
	private static final Logger logger =
			LoggerFactory.getLogger(Ch00Controller.class);
	//http://..../webapp1/ch01/content	
	@RequestMapping("/content")
	public String content() {
		logger.info("실행");
		//WEB-INF/views/밑의 이름/.jsp
		return "ch00/content";
	}
	//주석 ㅇ
}
