package com.green.mapper;

import java.util.List;

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
public class BoardMapperTests {
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	//@Test
	public void testGetList() {
		mapper.getList().forEach(i->log.info(i));
		
		//1)반복문
		/*List<BoardVO> a = mapper.getList();
		  for(int i0; i<a.size(); i++){
		  	log.info(a.get(i).getWriter());
		  }*/
		/*for(int i=0; i<mapper.getList().size(); i++) {
			log.info(mapper.getList().get(i));			
		}*/
		//2)advanced for문
		//for(BoardVO i : mapper.getList()) log.info(i.getWriter());
	}
	
	//@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새글");
		board.setContent("새 내용");
		board.setWriter("병아리");
		mapper.insert(board);
	}
	
	//@Test
	public void testRead() {
		BoardVO a = mapper.read(1L);
		System.out.println("하나만 읽은 데이터는 : " + a);
	}
	
	//@Test
	public void TestDelete() {
		int a = mapper.delete(22L);
		System.out.println("삭제한 데이터의 개수: " + a);//삭제된 개수 반환
	}
	
	//@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(1L);
		board.setTitle("제목1");
		board.setContent("내용1");
		board.setWriter("저자1");
		int count = mapper.update(board);
		log.info("수정된 개수는 : " + count);
	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		//10개씩 3페이지
		cri.setAmount(10);
		cri.setPageNum(3);
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(i -> log.info(i));
	}
}
