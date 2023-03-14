package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	// Oracle DB의 시스템 시간을 가져온다.
	// 어떤 쿼리를 쓰냐에 따라 맞는 어노테이션을 붙여줘야 한다.
	// 한번 안에 세팅 해 놓으면 변경하지 못하는 FINAL 변수이다.
	@Select("SELECT sysdate FROM dual") 
	public String getTime(); // 인터페이스라서 구현하지 않는다. = 중괄호 쓰지 않음.
	
	// src/main/resources안의 TimeMapper.xml에서 쓸 메서드. 어노테이션은 필요 없다.
	public String getTime2();
	
}