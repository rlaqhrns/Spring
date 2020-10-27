package com.green.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {

	@Setter(onMethod_ = @Autowired) //자동주입(autowired) setter 이용하여
	private Chef chef; // Restaurant 멤버변수 chef에 스프링이 알아서 주입(Inject)
	
	
}
