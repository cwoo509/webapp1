package com.mycompany.webapp.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.webapp.controller.dto.Ch03Dto;

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
	
	@RequestMapping("/method1")//다섯개의 데이터를 가장 쉽게 받는 방법은 매개변수
	public String method1(
			String param1,	int param2, double param3, 
			boolean param4, 
			@DateTimeFormat(pattern="yyyy-MM-dd")Date param5) {
	logger.info("param1:" + param1 );
		logger.info("param2:" + param2 );
		logger.info("param3:" + param3 );
		logger.info("param4:" + param4 );
		logger.info("param5:" + param5 );
		return "ch03/content";
	}
	@RequestMapping("/method2")//다섯개의 데이터를 가장 쉽게 받는 방법은 매개변수
	public String method2(
			@RequestParam("param1") String arg1,
			@RequestParam("param2") int arg2,
			double param3, 
			boolean param4, 
			@DateTimeFormat(pattern="yyyy-MM-dd")Date param5) {
	logger.info("param1:" + arg1 );
		logger.info("param2:" + arg2 );
		logger.info("param3:" + param3 );
		logger.info("param4:" + param4 );
		logger.info("param5:" + param5 );
		return "ch03/content";
	}
	
	
	@RequestMapping("/method3")//이 메소드는 4개의 매개값을 받고싶지만 브라우져에서 보낼때는 한 개만 보냈다.
	public String method3(
		String param1,
		@RequestParam(defaultValue="0") int param2,
		@RequestParam(defaultValue="0.0") double param3, 
		@RequestParam(defaultValue="false") boolean param4) {

		logger.info("param1:" + param1 );
		logger.info("param2:" + param2 );
		logger.info("param3:" + param3 );
		logger.info("param4:" + param4 );
		return "ch03/content";
	}
	@RequestMapping("/method4")//이 메소드는 4개의 매개값을 받고싶지만 브라우져에서 보낼때는 한 개만 보냈다.
	public String method4(Ch03Dto dto)	{
	
		logger.info("param1:" + dto.getParam1());
		logger.info("param2:" + dto.getParam2());
		logger.info("param3:" + dto.getParam3());
		logger.info("param4:" + dto.isParam4());
		logger.info("param4:" + dto.getParam5());
		return "ch03/content";
	}
}
