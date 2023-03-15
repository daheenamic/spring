package org.zerock.image.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

/*
 *  Spring 자동생성 어노테이션 - root-context.xml에 아래처럼 설정이 되어 있어야 어노테이션 사용 가능.
 *  <annotation-driven /> <context:component-scan base-package="org.zerock" />
 *  @Controller, @Component, @Service, @Repository(DAO에 해당-컴퓨터를 꺼도 DB에 저장되는 부분)
 *  @RestController(Ajax같이 원본 데이터를 그대로 보낼 때 사용하는 Controller), @Advice(예외처리)
 */

@Controller
@RequestMapping("/image")
@Log4j
public class ImageController {
	
	String module = "image";
	
	@RequestMapping("/list.do")
	public String list() {
		log.info("이미지 리스트");
		return module+"/list";
	}
	
	@RequestMapping("/view.do")
	// 전달되는 변수로 받을 때는 한개씩 따로따로 받는다.
	public String view(long no) {
		log.info("이미지 보기");
		log.info("no="+no);
		return module+"/view";		
	}
	
	// 이미지를 선택해서 보내주는 처리
	@GetMapping("/write.do")
	public String writeForm() {
		return module+"/write";
	}
	
	@PostMapping("write.do")
	// 프로젝트 할 때는 VO 객체를 받아서 전달해야 한다.
	// 여러개 받을 때는 배열[]로 받으면 되고, 한 개만 받으면 배열처리 안해도 됨.
	public String write(String title, MultipartFile[] files) {
		
		log.info("title: "+title);
		for(MultipartFile mfile : files) {
			// 데이터가 있는것만 log에 찍기
			if(!mfile.getOriginalFilename().equals("")) {
			log.info("-------------------------------");
			log.info("name:" + mfile.getOriginalFilename());
			log.info("size:" + mfile.getSize());
			}
		}
		return "redirect:list.do";
	}
}
