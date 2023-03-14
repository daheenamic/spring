package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {
	// @Inject - java DI
	// @Autowired - Spring
	// @Setter - lombok library : Spring Autowired을 사용한다.
	@Setter(onMethod_ = @Autowired) // 언더바를 붙여야 오류가 나지 않는다.
	private Chef chef;
}
