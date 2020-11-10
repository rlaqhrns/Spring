package com.green.vo;

import java.util.Date;

import lombok.Data;

@Data
public class CustomerVO {
	private int cus_id;
	private String cus_name;
	private String cus_password;
	private String cus_serial;
	private int deposit;
	private int withdraw;
	private int balance;
	private Date regDate; //등록일
	private Date updateDate; //수정일
	private String booleanLoan;
	
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	
	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	
	public void setBalance() {
		this.balance += getDeposit() + getWithdraw();
		setBooleanLoan();
	}
	
	public void setBooleanLoan() {
		this.booleanLoan = (getBalance() >= 500)? "Y" : "N";
		
	}
	
}
