package com.mycompany.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch06")// 공통경로
public class Ch06Controller {
	private static final Logger logger =
			LoggerFactory.getLogger(Ch06Controller.class);
	
	@GetMapping("/content")
	public String content() {
		logger.info("실행");
		return "ch06/content";
	}
	
	@GetMapping("/forward")
	public String forward() {
		logger.info("실행");
		return "ch06/forward";
	}
	@GetMapping("/redirect")
	public String redirect() {
		logger.info("실행");
		return "redirect:/ch06/content";
	}
	@GetMapping("/login")
	public String login() {
		logger.info("로그인 성공을 했다");
		return "redirect:/ch05/content";
	}
	@GetMapping("/boardwrite")
	public String boardwrite() {
		logger.info("게시물 저장 성공 ");
		return "redirect:/ch06/boardlist";
	}
	@GetMapping("/list")
	public String boardlist() {
		logger.info("게시물 저장 성공 ");
		return "ch06/list";
	}
}