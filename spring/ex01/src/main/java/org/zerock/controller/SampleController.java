package org.zerock.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;


// uri - /sample/*
// mapping은 클래스 위, 메서드 위에 -> 최종적으로 적용되는 것은 메서드 위의 Mapping 
// -> 클래스 매핑 + 메서드 매핑 = 전체 uri에 해당이 된다.
@Controller
@RequestMapping("/sample/*") 
// uri가 이 패턴에 맞으면 밑의 클래스를 실행하고 아직 jsp파일이 없으므로 jsp는 찾을 수 없다고 나오지만
// 콘솔창에 log.info에 입력한 정보는 출력된다.
@Log4j
public class SampleController {
	
	// String - redirect:가 안붙으면 jsp로 forward, redirect:가 붙어있으면 해당 uri로 이동.
	// JSP에서는 수동으로 했지만 Spring에서는 알아서 해준다.
	// void면 uri가 jsp의 정보가 된다. ex) /sample/test -> /sample/test.jsp를 자동으로 찾는다.
	@RequestMapping("/basic")
	public void basic() {
		log.info("basic....");
	}
	
	// GET이나 POST방식 중 어떤것이 들어오든 상관없을 때는 RequestMapping을 쓰고 뒤에 method를 쓰면 된다.
	@RequestMapping(value="/basicGet", method = {RequestMethod.GET,RequestMethod.POST})
	public void basicGet() {
		log.info("basic Get.....................");
		
	}
	
	// @RequstMapping에서 Get 방식만 받도록 정의 해 놓은 어노테이션 -> GetMapping
	@GetMapping("/basicGet2")
	public void basicGet2() {
		log.info("basic Get2........................");
	}
}