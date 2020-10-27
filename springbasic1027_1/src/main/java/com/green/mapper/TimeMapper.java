package com.green.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	@Select("select sysdate from dual")
	public String getTime();
	
	public String getTime2();//select annotation(@) 없음 
}
//mybatis는 인터페이스를 이용하여 객체를 생성해줌

//@Select 이렇게 하지 않고 xml파일로 만들어서 사용함 