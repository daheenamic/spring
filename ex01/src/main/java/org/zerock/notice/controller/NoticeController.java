package org.zerock.notice.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.notice.vo.NoticeVO;

import lombok.extern.log4j.Log4j;

/*
 *  Spring 자동생성 어노테이션 - root-context.xml에 아래처럼 설정이 되어 있어야 어노테이션 사용 가능.
 *  <annotation-driven /> <context:component-scan base-package="org.zerock" />
 *  @Controller, @Component, @Service, @Repository(DAO에 해당-컴퓨터를 꺼도 DB에 저장되는 부분)
 *  @RestController(Ajax같이 원본 데이터를 그대로 보낼 때 사용하는 Controller), @Advice(예외처리)
 */

@Controller
@RequestMapping("/notice")
@Log4j
public class NoticeController {
	
	// 변수 선언해서 이거만 바꾸면 Controller를 변경할 때 여기만 바꾸면 된다.
	String module = "notice";
	
	@RequestMapping("/list.do")
	public String list() {
		log.info("공지사항 리스트");
		return module+"/list";
	}
	
	@RequestMapping("/view.do")
	// 전달되는 변수로 받을 때는 한개씩 따로따로 받는다.
	public String view(long no) {
		log.info("공지사항 보기");
		log.info("no="+no);
		return module+"/view";		
	}
	
	@GetMapping("/write.do")
	public String writeForm() {
		log.info("공지사항 글쓰기폼");
		return module+"/write";		
	}
	
	@PostMapping("/write.do")
	public String write(NoticeVO vo) {
		log.info("공지사항 글쓰기처리");
		log.info(vo);
		return "redirect:list.do";		
	}
	
	@GetMapping("/update.do")
	public String updateForm() {
		log.info("공지사항 수정폼");
		return module+"/update";
	}
	
	@PostMapping("/update.do")
	public String update() {
		log.info("공지사항 수정처리");
		return "redirect:view.do?no=10";		
	}
	
	@PostMapping("/delete.do")
	// @RequestParam([name, defaultValue, required, value])
	// - 넘어오는 데이터의 이름이 변수와 다른 경우, 값이 넘어오지 않는 경우 기본값, 필수 항목, 값 세팅
	// - 여러개의 데이터를 받을 때 리스트로 받으면 클래스를 사용해야 한다.
//	public String delete(long[] no) {
	public String delete(@RequestParam("no")ArrayList<Long> no) {
		log.info("공지사항 삭제처리");
		// 배열로 받을 때는 Arrays.toString으로 해야 출력
//		log.info(Arrays.toString(no));
		// List로 받을때는 그냥 변수명으로 출력 가능.
		log.info(no);
		return "redirect:list.do";
	}

}
