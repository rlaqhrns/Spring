package com.green.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	//JPA(java persistent API(@Entity))
	private Long bno; //게시물 번호
	private String title; //제목
	private String content; //내용
	private String writer; //저자
	private Date regDate; //등록일
	private Date updateDate; //수정일
}
