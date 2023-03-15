package org.zerock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.zerock.image.controller.ImageController;

import lombok.extern.log4j.Log4j;

/*
 *  Spring 자동생성 어노테이션 - root-context.xml에 아래처럼 설정이 되어 있어야 어노테이션 사용 가능.
 *  <annotation-driven /> <context:component-scan base-package="org.zerock" />
 *  @Controller, @Component, @Service, @Repository(DAO에 해당-컴퓨터를 꺼도 DB에 저장되는 부분)
 *  @RestController(Ajax같이 원본 데이터를 그대로 보낼 때 사용하는 Controller), @Advice(예외처리)
 */

@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
	
	// 500 예외 전체 - Exception
	@ExceptionHandler(Exception.class)
	public String exception(Exception e, Model model) {
		log.error("Exception ...");
		model.addAttribute("exception", e);
		log.error(model);
		return "error/error_page"; // jsp 정보
	}
	
	// 400번 오류 처리
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException e) {
		return "error/custom404";
	}
}
