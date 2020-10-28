package com.green.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.green.domain.BoardVO;

public interface BoardMapper {
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	//insert만 처리하고 생성된 pk값을 알 필요가 없을 경우
	public void insert(BoardVO board);
	//insert 실행하고 생성된 pk값을 알아야 하는 경우
	public void insertSelectKey(BoardVO board);
	//xml에서 insertSelectKey는 @SelectKey라는 mybatis의
	//어노테이션을 이용하여 @SelectKey는 PK값을 미리(before) SQL을 통해서 처리해두고
	//특정한 이름으로 결과를 보관하는 방식
	public BoardVO read(Long bno); //방금전에 한 selectKey의 query문이 같음
	public int delete(Long bno);
}
