package com.mycompany.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/ch02")
public class Ch02Controller {
	private static final Logger logger =
			LoggerFactory.getLogger(Ch02Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		logger.info("실행");
		return "ch02/content";
	}
		//@RequestMapping(value="/request1")//GET과 POST를 둘다 지원함
		@RequestMapping(value="/getMethod", method=RequestMethod.GET) 
		//get방식으로 요청해야만 실행할 수 있는 방식(이 때 post를 사용하면 405에러가 뜸)
		//@RequestMapping(value="/request1", method=RequestMethod.POST) 
		//post방식으로 요청해야만 실행할 수 있는 방식(이 때 get를 사용하면 405에러가 뜸)
		public String getMethod() {
			logger.info("실행");
			return "ch02/content";
		}
		//@RequestMapping(value="/postMethod", method=RequestMethod.POST)
		@PostMapping("/postMethod")
		public String postMethod() {
			logger.info("실행");
			return "ch02/content";
		}
		//@RequestMapping(value="/join", method=RequestMethod.GET)
		@GetMapping("/join")
		public String joinForm() {
			logger.info("회원가입 양식을 보냈습니다.");
			return "ch02/joinForm";
		}
		//@RequestMapping(value="/joinAsync", method=RequestMethod.GET)
		@GetMapping("/joinAsync")
		public String joinFormAsync() {
			logger.info("??");
			return "ch02/joinFormAsync";
		}
		
		//@RequestMapping(value="/join", method=RequestMethod.POST)
		@PostMapping("/join")
		public String join() {
			logger.info("회원가입이 완료되었습니다.");
			return "ch02/content";
		}
}