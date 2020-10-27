package com.green.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//root-context.xml 경로 알려주는 코드
@Log4j
public class SampleTests {

	//Test 는 서버 돌리는게 아니고 JUnit test를 Run as 로 돌림
	@Setter(onMethod_ = {@Autowired})
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		//assertNotNull(restaurant); //not null이면 통과라는 뜻 (assert)
		 
		log.info(restaurant); 
		// 예외가 발생하지 않으면 통과됨 
		log.info("---------------------------");
		log.info(restaurant.getChef());
	}
}
