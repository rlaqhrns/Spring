package com.green.service;

import java.util.List;

import com.green.domain.BoardVO;
import com.green.domain.Criteria;

public interface BoardService {
	public void register(BoardVO board);//insert
	public BoardVO get(Long bno);//mapper에서는 read
	public boolean modify(BoardVO board); //update
	public boolean remove(Long bno);//delete
	public List<BoardVO> getList(Criteria cri);
	//public List<BoardVO> getList();//동일
	public int getTotal(Criteria cri);
}
