package org.zerock.board.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.board.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

// 테스트 프로그램을 지정
@RunWith(SpringJUnit4ClassRunner.class)
// 설정 파일을 불러와서 적용 시킨다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_ = { @Autowired })
	private BoardMapper mapper;
	
	@Test
	public void testList() {
		log.info("mapper 리스트 테스트------------------------");
		log.info(mapper.list());
	}
	
	@Test
	public void testView() {
		log.info("mapper 글보기 테스트------------------------");
		long no = 1;
		log.info(mapper.view(no));
	}
}