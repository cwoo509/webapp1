
package com.mycompany.webapp.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.controller.dto.Ch07Board;
import com.mycompany.webapp.controller.dto.Ch08Board;
@Controller
@RequestMapping("/ch08")
public class Ch08Controller {
		private static final Logger logger = LoggerFactory.getLogger(Ch08Controller.class);
	
		@GetMapping("/content")
		public String content() {
			logger.info("실행");
			return "ch08/content";
		}
		
		@GetMapping("/method1")
		public String method1(HttpSession session) {
			session.setAttribute("name", "이창우");
			session.setAttribute("age", 28);
			session.setAttribute("job", "인공지능 개발자");
			return "ch08/el";
		}
		
		@GetMapping("/method2")
		public String method2(HttpSession session) {
			Ch07Board board = new Ch07Board();
			board.setNo(1);
			board.setTitle("너무 추워요");
			board.setContent("과제하면 더 추워요.");
			board.setWriter("머신");
			board.setDate(new Date());
			session.setAttribute("board1", board);
			return "ch08/el";
		}
		
		@GetMapping("/method3")
		public String method3(HttpSession session) {
			List<Ch07Board> list = new ArrayList<>();
			for(int i=1; i<=10; i++) {
				Ch07Board board = new Ch07Board();
				board.setNo(i);
				board.setTitle("너무 추워요" + i);
				board.setContent("과제하면 더 추워요." + i);
				board.setWriter("머신"+ i);
				board.setDate(new Date());
				list.add(board);
			}
			session.setAttribute("boardList", list);
			return "ch08/el";
		}
	@PostMapping("/login")
	public String login(String uid, String upassword, HttpSession session){
			if(uid.equals("admin") && upassword.contentEquals("12345")) {
			logger.info("로그인성공");
			session.setAttribute("loginStatus", uid);//로그인 되면 로그인 스테이터스에선 로그인된 아이디가 저장된다.
			}
			return "redirect:/ch08/content";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//세션내 데이터를 개별적으로 지우는 방식
		//session.removeAttribute("loginStatus");
		//세션내 데이터를 모두 지우는 방식
		session.invalidate();
		return "redirect:/ch08/content";
	}
	@PostMapping("/boardwrite")
	public String boardWrite(Ch08Board board, HttpSession session) {
		//ch08의 보드는 4개종류가 있으나 클라이언트에서는 2개만 들어온다. 즉 2개만 저장되고 나머지 두개는 디폴드 값으로 된다.
		//사용자가 로그인 한 상태면 아이디는 loginStatus에 저장되어 있다.
		String uid =(String) session.getAttribute("loginStatus");
		//해당이름의 값을 가지고 와서 저장한다. 다만 부모타입은 object타입 자식타입은 text타입이기때문에 강제타입변환이 피룡하다.
		if(uid != null) {//로그인이 되어 잇는 경우라면
			board.setWriter(uid);//객체의 작성자? 칸에 uid를 저장한다.
			logger.info("title" + board.getTitle());
			logger.info("title" + board.getContent());
			logger.info("title" + board.getWriter());
			logger.info("게시물을 성공적으로 저장함");
		}else {
			logger.info("로그인이 되어 있지 않습니다.");
		}
		return "redirect:/ch08/content";
	}
}



