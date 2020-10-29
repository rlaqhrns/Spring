package com.green;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class JpademoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);

	}
	public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		return new HiddenHttpMethodFilter();
	}

}
