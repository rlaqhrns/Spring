package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.mapper.BankMapper;
import com.green.mapper.LoanMapper;
import com.green.vo.CustomerVO;
import com.green.vo.LoanVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class BankServiceImpl implements BankService {
	@Setter(onMethod_=@Autowired)
	private BankMapper mapper;
	@Setter(onMethod_=@Autowired)
	private LoanMapper loanmapper;
	
	private LoanVO loan;
	@Override
	public void register(CustomerVO cus) {
		// TODO Auto-generated method stub
		String result = "";
		for(int i = 1; i<=14; i++) {
			if(i==1)result+= (int)Math.ceil(Math.random()*9);
			else {
			result += (int)Math.floor(Math.random()*10);
			}
			if((i==3) || (i==9))result+="-";
		}
		cus.setCus_serial(result);
		
		mapper.insert(cus);
		
		loan = new LoanVO(cus);
		loanmapper.insertLoan(loan);
		//System.out.println("레지스터 cus" + cus.getCus_id());
		//System.out.println("레지스터 loan" + loan.getLo_id());
		//loan.setLo_balance((int)cus.getBalance()*10); //최초 가입시 잔고는 0임;;
	}

	@Override
	public CustomerVO get(int cus_id) {
		// TODO Auto-generated method stub
		
		return mapper.select(cus_id);
		
	}

	@Override
	public void modify(CustomerVO cus) {
		// TODO Auto-generated method stub
		mapper.update(cus);
		loan = new LoanVO(cus);
		loanmapper.updateName(loan);

	}

	@Override
	public void remove(int cus_id) {
		// TODO Auto-generated method stub
		mapper.delete(cus_id);
		loanmapper.delete(cus_id);
	}

	@Override
	public void bankTransaction(CustomerVO cus) {
		// TODO Auto-generated method stub
		mapper.bankTransaction(cus);
		
		loan = new LoanVO(mapper.select(cus.getCus_id()));
		loanmapper.updateBalance(loan);
		System.out.println("cus getbalance : " + cus.getBalance());
		System.out.println("loan getbalance : " + loan.getLo_balance()
		);
		//System.out.println("여기다여기여" + cus.getCus_id());
		//System.out.println("여기는 " + loan.getLo_id());


	}

	@Override
	public List<CustomerVO> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public void loan(LoanVO loan) {
		// TODO Auto-generated method stub
		loanmapper.Loan(loan);
	}

	
}
