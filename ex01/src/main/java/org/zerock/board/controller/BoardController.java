package org.zerock.board.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.board.service.BoardServiceImpl;
import org.zerock.board.vo.BoardVO;
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
	
	@Autowired
	private BoardServiceImpl service;
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		log.info("게시판 리스트");
//		System.out.println(10/0);
		model.addAttribute("list",service.list());
		return "board/list";
	}
	
	@RequestMapping("/view.do")
	// 전달되는 변수로 받을 때는 한개씩 따로따로 받는다.
	public String view(long no, int inc, Model model) {
		log.info("게시판 보기");
		BoardVO vo = service.view(no, inc);
		
		// Date타입의 date 변수에 vo에 있는 writeDate를 저장한다
		// 현재 writeDate : Mon Feb 13 09:39:44 KST 2023 <- 이런형식
		Date date = vo.getWriteDate();
		
		// DateFormat타입의 df변수에 yyyy-MM-dd 형식의 SimpleDateFormat을 저장한다
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		// String타입의 dateStr 변수에 vo에 객체에 저장되어 있던 writeDate를 yyyy-MM-dd의 형식으로 String 타입으로 저장한다.
		String dateStr = df.format(date);
		
		// vo에 vo객체를 담고
		model.addAttribute("vo",vo);
		
		// writeDate에 아까 "yyyy-MM-dd" 형식의 String 타입으로 저장한 writeDate를 담는다
		model.addAttribute("writeDate",dateStr);
		
		log.info("no="+no+", inc="+inc);
		return "board/view";
	}
	
	@GetMapping("/write.do")
	public String writeForm() {
		log.info("게시판 글쓰기폼");
		return "board/write";		
	}
	
	@PostMapping("/write.do")
	public String write(BoardVO vo) {
		log.info("게시판 글쓰기처리");
		log.info(vo);
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
		return "redirect:view.do?no=10&inc=1";		
	}
	
	@PostMapping("/delete.do")
	// @RequestParam([name, defaultValue, required, value])
	// - 넘어오는 데이터의 이름이 변수와 다른 경우, 값이 넘어오지 않는 경우 기본값, 필수 항목, 값 세팅
	// - 여러개의 데이터를 받을 때 리스트로 받으면 클래스를 사용해야 한다.
//	public String delete(long[] no) {
	public String delete(@RequestParam("no")ArrayList<Long> no) {
		log.info("게시판 삭제처리");
		// 배열로 받을 때는 Arrays.toString으로 해야 출력
//		log.info(Arrays.toString(no));
		// List로 받을때는 그냥 변수명으로 출력 가능.
		log.info(no);
		return "redirect:list.do";
	}

}
