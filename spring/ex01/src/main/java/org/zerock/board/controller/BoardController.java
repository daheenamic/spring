package org.zerock.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.log4j.Log4j;

/*
 *  Spring 자동생성 어노테이션 - root-context.xml에 아래처럼 설정이 되어 있어야 어노테이션 사용 가능.
 *  <annotation-driven /> <context:component-scan base-package="org.zerock" />
 *  @Controller, @Component, @Service, @Repository(DAO에 해당-컴퓨터를 꺼도 DB에 저장되는 부분)
 *  @RestController(Ajax같이 원본 데이터를 그대로 보낼 때 사용하는 Controller), @Advice(예외처리)
 */

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {
	
	@RequestMapping("/list.do")
	public String list() {
		log.info("게시판 리스트");
		return "board/list";
	}
	
	@RequestMapping("/view.do")
	public String view() {
		log.info("게시판 보기");
		return "board/view";		
	}
	
	@GetMapping("/write.do")
	public String writeForm() {
		log.info("게시판 글쓰기폼");
		return "board/write";		
	}
	
	@PostMapping("/write.do")
	public String write() {
		log.info("게시판 글쓰기처리");
		return "redirect:list.do";		
	}
	
	@GetMapping("/update.do")
	public String updateForm() {
		log.info("게시판 수정폼");
		return "board/update";
	}
	
	@PostMapping("/update.do")
	public String update() {
		log.info("게시판 수정처리");
		return "redirect:view.do";		
	}
	
	@PostMapping("/delete.do")
	public String delete() {
		log.info("게시판 삭제처리");
		return "redirect:list.do";		
	}

}
