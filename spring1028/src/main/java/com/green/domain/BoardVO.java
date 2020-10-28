package com.green.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private Long bno; //게시글 번호
	private String title;//제목
	private String content;//내용
	private String writer;//저자
	private Date regDate; //등록일
	private Date updateDate; //수정일
}
