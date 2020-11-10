package com.green.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LoanVO {
	private int lo_id;
	private String lo_name;
	private int lo_total;
	private int lo_withdraw;
	private int lo_balance;
	
	public LoanVO(CustomerVO cus) {
		this.lo_id = cus.getCus_id();
		this.lo_name = cus.getCus_name();
		this.lo_balance = cus.getBalance()*10;
		
	}
}
