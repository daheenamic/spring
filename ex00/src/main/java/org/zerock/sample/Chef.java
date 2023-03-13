package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

/*
 *  Spring 자동생성 어노테이션 - root-context.xml에 설정이 되어 있어야 한다.
 *  <annotation-driven /> <context:component-scan base-package="org.zerock" />
 *  @Controller, @Component, @Service, @Repository(DAO에 해당-컴퓨터를 꺼도 DB에 저장되는 부분)
 *  @RestController(Ajax같이 원본 데이터를 그대로 보낼 때 사용하는 Controller), @Advice(예외처리)
 */

@Component
@Data // vo 객체를 생각하면 된다. -getter/setter, toString() 사용 가능.
public class Chef {

}
