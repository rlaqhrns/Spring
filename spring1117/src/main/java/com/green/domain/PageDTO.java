package com.green.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private int startPage;//시작 페이지
	private int endPage;//끝 페이지
	private boolean prev, next;//다음 페이지, 이전 페이지가 있는지 참/거짓
	
	private int total;//총 게시글
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int) (Math.ceil(cri.getPageNum()/10.0))*10;
		this.startPage = this.endPage - 9;
		
		//305p
		//만일 끝 번호(endPage)와 한 페이지당 출력되는 데이터의 수(amount)의 곱이 전체 데이터의 수(total)보다 크다면
		//끝 번호(endPage)는 total을 이용하여 다시 계산되어야 함
		//먼저 전체 데이터의 수(total)을 이용하여 진짜 끝 페이지(realEnd)가 몇 번까지 있는지 계산함
		//만일 진짜 끝 페이지(realEnd)가 구해둔 끝 번호(endPage)보다 작다면 끝 번호는 작은 값이 되어야 함
		//끝 번호 공식은 Math.ceil(소수점을 올림으로 처리)을 이용하여 구함
		//1페이지의 경우 Math.ceil(0.1)*10 = 10
		//10페이지의 경우 Math.ceil(1)*10 = 10
		//11페이지의 경우 Math.ceil(1.1)*10 = 20
		//만일 화면에서 10개씩 보여준다면 시작 번호(startPage)는 무조건 끝 번호(endPage)에서 9라는 값을 뺀 값이 됨
		int realEnd = (int) (Math.ceil((total*1.0)/cri.getAmount()));
		if(realEnd<this.endPage) {//끝 페이지부터 계산해야 편함
			this.endPage = realEnd; 
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
