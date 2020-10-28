package com.green.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.green.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_=@Autowired) //DI(의존주입)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(i -> log.info(i));
	}
	
	@Test
	public void testInsert() {
		for(int i = 0; i<5; i++) {
			
			BoardVO board = new BoardVO();
			board.setTitle("새로 작성하는 글");
			board.setContent("새로 작성하는 글");
			board.setWriter("이재오");
			mapper.insert(board);
			log.info(board);
		}
	}
	@Test
	public void testInsertKey() { //콘솔창 확인, 교재 읽기!!
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글 select key");
		board.setContent("새로 작성하는 글 select key");
		board.setWriter("이재오 select key");
		mapper.insert(board);
		log.info(board);
	}
	@Test
	public void testRead() {
		//존재하는 id값을 주세
		BoardVO board = mapper.read(5L);
		log.info("하나만 읽은 데이터"+ board);
	}
}
