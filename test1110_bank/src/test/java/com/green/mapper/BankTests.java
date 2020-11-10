package com.green.mapper;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.green.vo.CustomerVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		"file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BankTests {
	@Setter(onMethod_=@Autowired)
	private BankMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(i-> log.info(i.getCus_name() +"의 잔고 : " +i.getBalance() + "원"));
	}
	
	//@Test
	public void testInsert() {
		CustomerVO customer = new CustomerVO();
		customer.setCus_name("BK");
		customer.setCus_password("1111");
		customer.setCus_serial("000-0000-0000");
		
		mapper.insert(customer);
	}
	
	//@Test
	public void testRead() {
		CustomerVO a = mapper.select(1);
		System.out.println("하나를 읽은 데이터는 " +a);
	}
	
	//@Test
	public void testDelete() {
		int a  = mapper.delete(1); //bno가 있는 번호를 추가함 
		System.out.println("잘 삭제되었습니다. " +a); //삭제된 갯수 반환 
	}
	
	//@Test
	public void testUpdate() {
		CustomerVO customer = new CustomerVO();
		customer.setCus_id(10);
		customer.setCus_name("BK1");
		customer.setCus_password("11111");
		customer.setCus_serial("000-01010-0000");
		mapper.update(customer);
		
	}
	//@Test
	public void testBankTransaction() {
		CustomerVO customer = new CustomerVO();
		customer.setCus_name("KBK");
		customer.setDeposit(3);
		customer.setWithdraw(66);
		String result = "";
		for(int i = 1; i<=14; i++) {
			if(i==1)result+= (int)Math.ceil(Math.random()*9);
			else {
			result += (int)Math.floor(Math.random()*10);
			}
			if((i==3) || (i==9))result+="-";
		}
		customer.setCus_serial(result);
		log.info("1234567890" +customer.getCus_serial());
		mapper.bankTransaction(customer);
		
	}
	//@Test
	public void test() {
		String result = "";
		for(int i = 1; i<=14; i++) {
			if(i==1)result+= (int)Math.ceil(Math.random()*9);
			else {
			result += (int)Math.floor(Math.random()*10);
			}
			if((i==3) || (i==9))result+="-";
		}
		
		System.out.println((int)Math.floor(Math.random()*9));
		System.out.println("result : " + result);
	}
	

}
