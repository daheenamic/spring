package org.zerock.board.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

// 테스트 프로그램을 지정
@RunWith(SpringJUnit4ClassRunner.class)
// 설정 파일을 불러와서 적용 시킨다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
		
	@Setter(onMethod_ = { @Autowired })
	private BoardServiceImpl boardServiceImpl;
	
	@Test
	public void testExist() {
		assertNotNull(boardServiceImpl);
		
		log.info(boardServiceImpl);
		log.info("------------------------");
		log.info(boardServiceImpl.getDao());
		// 처음에 getDao가 안떴는데 BoardServiceImpl 클래스에 @Data 어노테이션이 없어서 안떴음
		// getter/setter를 쓰려면 @Data 꼭 있어야 하는 것 잊지 말기!!
	}
	
}