package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
@Log4j // System.out.println() 대신 사용하는 어노테이션
public class DataSourceTests {

	@Setter(onMethod_ = @Autowired)
	private DataSource dataSource;

	@Setter(onMethod_ = @Autowired)
	private SqlSessionFactory sqlSessionFactory;

	@Test
	public void testConnection() {
		// try (객체 선언 생성) { ~ } catch() { ~~ } -> 객체 자동 닫기
		try (Connection con = dataSource.getConnection()) {
			String sql = "SELECT sysdate FROM dual";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			log.info(rs.getString(1));
			log.info(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMyBatis() {
		// try 안에 여러개의 자원 선언할 수 있음. 세미콜론으로 구분하면 됨.
		try (SqlSession session = sqlSessionFactory.openSession(); Connection con = session.getConnection();) {
			log.info(session);
			String sql = "SELECT sysdate FROM dual";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			log.info(rs.getString(1));
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}