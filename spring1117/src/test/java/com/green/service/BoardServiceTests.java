package com.green.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.green.domain.BoardVO;
import com.green.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	@Setter(onMethod_= {@Autowired})
	private BoardService service;
	
	@Test
	public void testList() {
		log.info("서비스가 잘 들어오나? " + service);
		service.getList(new Criteria(2, 10)).forEach(i->log.info("여기는 서비스 "));
	}
	
	//@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);//null이면 예외 발생
	}
	
	//@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("서비스에서 새로 작성하는 글 ");
		board.setContent("서비스에서 새로 작성하는 내용");
		board.setWriter("서비스에서 새로 작성한 저자");
		service.register(board);
		log.info("생성된 게시글의 번호 " + board.getBno());
	}
	
	//@Test
	public void testGet() {
		log.info(service.get(31L));
	}
	
	//@Test
	public void testDelete() {
		log.info("삭제 결과 " + service.remove(30L));
	}
	
	//@Test
	public void testUpdate() {
		BoardVO board = service.get(31L);
		if(board == null) return;
		board.setTitle("31번째 수정");
		log.info("수정 결과" + service.modify(board));
	}
}
