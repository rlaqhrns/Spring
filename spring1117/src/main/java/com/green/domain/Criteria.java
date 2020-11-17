package com.green.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum; //페이지 넘버
	private int amount; //한페이지당 게시글갯수
	private String type; //�˻��� content(c), writer(w), title(t)
	private String keyword; //�˻�
	
	public Criteria() { //기본생성자일경우
		this(1,10); //기본1번~10번게시글
		
	}

	public Criteria(int pageNum, int amount) {
		// TODO Auto-generated constructor stub
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
		return type == null? new String[] {}: type.split(""); //3�� ������ 
	}
	
	
	
}
