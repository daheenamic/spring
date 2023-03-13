package org.zerock.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.board.dao.BoardDAOImpl;

import lombok.Data;
import lombok.Setter;

/*
 *  Spring 자동생성 어노테이션 - root-context.xml에 아래처럼 설정이 되어 있어야 어노테이션 사용 가능.
 *  <annotation-driven /> <context:component-scan base-package="org.zerock" />
 *  @Controller, @Component, @Service, @Repository(DAO에 해당-컴퓨터를 꺼도 DB에 저장되는 부분)
 *  @RestController(Ajax같이 원본 데이터를 그대로 보낼 때 사용하는 Controller), @Advice(예외처리)
 */

@Service
@Data
public class BoardServiceImpl {
	
	@Setter(onMethod_ = @Autowired)
	private BoardDAOImpl dao;
	
}