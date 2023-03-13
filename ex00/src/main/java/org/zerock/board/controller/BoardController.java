package org.zerock.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.board.service.BoardServiceImpl;
import org.zerock.board.vo.BoardVO;

import lombok.Setter;
import lombok.extern.java.Log;

@Controller
@Log
public class BoardController {
	
	@Setter(onMethod_ = { @Autowired })
	private BoardServiceImpl service;
	
	@RequestMapping("/board/list.do")
	public String list() {
		log.info("게시판리스트i");
		log.warning("게시판리스트w");
		BoardVO vo = new BoardVO();
		// BoardVO 클래스에서 getter/setter, toString 메서드를 만들지 않았지만 lombok라이브러리를 추가했기 때문에 사용이 가능하다.
		vo.setNo(10);
		log.info(vo.toString());
		return "board/list";
	}
	
	@RequestMapping(value = "/board/write.do", method = RequestMethod.GET)
	public String writeForm() {
		return "board/write";
	}
	
	@RequestMapping(value = "/board/write.do", method = RequestMethod.POST)
	public String write() {
		// list로 자동이동
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value = "/board/view.do", method = RequestMethod.GET)
	public String view() {
		return "board/view";
	}
	
	@RequestMapping(value = "/board/update.do", method = RequestMethod.GET)
	public String updateForm() {
		return "board/update";
	}
	
	@RequestMapping(value = "/board/update.do", method = RequestMethod.POST)
	public String update() {
		// view로 자동이동
		return "redirect:/board/view.do";
	}
	
	@RequestMapping(value = "/board/delete.do", method = RequestMethod.GET)
	public String delete() {
		return "redirect:/board/list.do";
	}
}
