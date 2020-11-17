package com.green.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.green.domain.BoardVO;
import com.green.domain.Criteria;

public interface BoardMapper {
	// xml 안만들떄 쓰는거 @Select("")
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	public void insert(BoardVO board);
	public void insertSelectKey(BoardVO board);
	//여기에 해당하는 xml 파일이 피룡함(sql문이 들어감)
	
	public BoardVO read(Long bno);
	public int delete(Long bno);
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public int update(BoardVO board);
	
	public int getTotalCount(Criteria cri);
}
