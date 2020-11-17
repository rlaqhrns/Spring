package com.green.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.green.domain.BoardVO;
import com.green.domain.Criteria;
import com.green.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	private BoardMapper mapper;

	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("여러개의 목록 가져오기......");
		return mapper.getListWithPaging(cri);
		
		//컨트롤러에서 바로 mybatis로 가는 것이 아니라 서비스 레이어에서 복잡한 비지니스 로직을 구현하고
		//그 결과를 DB와 연동하는 레이어로 독립적인 presentation 레이어
		/*for(BoardVO i: mapper.getList()) {
			if(i.getWriter().equals("그린"));
			System.out.println(i.getTitle());
		}*/
	}

	@Override
	public void register(BoardVO board) {
		log.info("서비스에서 등록......");
		mapper.insertSelectKey(board);
		
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("서비스에서 하나 얻어오기");
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("서비스에서 수정......");
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("서비스에서 삭제");
		return mapper.delete(bno) == 1;
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count 서비스 ");
		return mapper.getTotalCount(cri);
	}
}
