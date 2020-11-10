package com.green.jpademo.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class JpademoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);
	}

	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		return new HiddenHttpMethodFilter();
	}

//	@Bean
//	public FilterRegistrationBean filterRegistrationBean(){
//		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(hiddenHttpMethodFilter());
//		filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
//		return filterRegistrationBean;
//	}

}
