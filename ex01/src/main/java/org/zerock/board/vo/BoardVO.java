package org.zerock.board.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	private long no;
	private String title, content, writer, pw;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date writeDate;
	private long hit;
}
