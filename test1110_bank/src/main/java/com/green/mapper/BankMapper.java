package com.green.mapper;

import java.util.List;

import com.green.vo.CustomerVO;

public interface BankMapper {
	public List<CustomerVO> getList();
	public CustomerVO select(int cus_id);
	public void insert(CustomerVO cus);
	public int update(CustomerVO cus);
	public int delete(int cuscus_idId);
	public void bankTransaction(CustomerVO cus);
}
