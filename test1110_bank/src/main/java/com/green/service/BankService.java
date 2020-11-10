package com.green.service;

import java.util.List;

import com.green.vo.CustomerVO;
import com.green.vo.LoanVO;



public interface BankService {
	public void register(CustomerVO cus);
	public CustomerVO get(int cus_id);
	public void modify(CustomerVO cus);
	public void remove(int cus_id);
	public void bankTransaction(CustomerVO cus);
	public List<CustomerVO> getList();
	public void loan(LoanVO loan);
}
