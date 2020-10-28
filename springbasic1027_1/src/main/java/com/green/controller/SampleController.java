package com.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/sample/*")
//@Log4j
public class SampleController {
	@RequestMapping("/a")
	public void basic() {
		System.out.println("basic..................");
		
	}
}

