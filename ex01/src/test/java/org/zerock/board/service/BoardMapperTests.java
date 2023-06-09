package org.zerock.board.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.board.mapper.BoardMapper;
import org.zerock.board.vo.BoardVO;

import com.webjjang.util.PageObject;

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
		PageObject pageObject = new PageObject(1, 10);
		log.info(mapper.list(pageObject));
	}
	
	@Test
	public void testView() {
		log.info("mapper 글보기 테스트------------------------");
		long no = 1;
		log.info(mapper.view(no));
	}

	@Test
	public void testWrite() {
		log.info("mapper 글등록 테스트------------------------");
		BoardVO vo = new BoardVO();
		vo.setTitle("테스트제목");
		vo.setContent("테스트내용");
		vo.setWriter("테스트작성자");
		vo.setPw("1111");
		log.info(mapper.write(vo));
	}
}