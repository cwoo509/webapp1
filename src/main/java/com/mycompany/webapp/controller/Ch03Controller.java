package com.mycompany.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//컨트롤러 객체가 자동으로 만들어짐
@RequestMapping("/ch03") //경로에 챕터 3 이 있을때 컨트롤러가 요청처리를 하겠다.
 public class Ch03Controller {
	private static final Logger logger =
		LoggerFactory.getLogger(Ch03Controller.class);
	
	@GetMapping("content")
	 public String content() {
		logger.info("실행");
		return "ch03/content";
	}
}
