package org.zerock.board.vo;

import lombok.Data;

// Data를 저장하고 꺼낼 때 사용
@Data
public class BoardVO {
	
	// 여기서 getter/setter, toString()을 만들지 않았지만 lombok 라이브러리가 있어서 저절로 만들어져 있다.
	private long no;
	private String title;

}
