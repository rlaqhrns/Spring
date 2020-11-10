package com.green.mapper;

import java.util.List;

import com.green.vo.LoanVO;

public interface LoanMapper {
	public List<LoanVO> getLoan();
	public void insertLoan(LoanVO loan);
	public void Loan(LoanVO loan);
	public void updateBalance(LoanVO loan);
	public void delete(int lo_id);
	public void updateName(LoanVO loan);
}
