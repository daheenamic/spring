package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

// 테스트 프로그램을 지정을 해서 사용
@RunWith(SpringJUnit4ClassRunner.class)
// 설정 파일을 불러와서 적용
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j // 로그 출력 - 데이터 확인, 흐름 확인 (Sysout 찍어서 확인 했던 부분)
public class SampleTests {
	
	// @Inject - java DI, @Autowired - Spring, @Setter - lombok library : Spring Autowired을 사용한다.
	@Setter(onMethod_ = { @Autowired }) // {} : 배열. 여러개를 선언해서 사용 할 수 있다.
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		
		// not null인지 확인하는 메서드
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("-----------------------------------");
		log.info(restaurant.getChef());
	}

}
