package com.green.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import oracle.net.ano.Service;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardControllerTests {
	@Setter(onMethod_= {@Autowired})
	private WebApplicationContext ctx;//교재 214p
	//DispatcherServlet이 직접 사용하는 컨트롤러를 포함한 웹 관련 빈을 등록하는데 사용함.
	private MockMvc mockMvc;//가짜로 만듦(가짜 MVC)
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	//@Test
	public void testList() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	
	//@Test
	public void testRegister() throws Exception{
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title", "컨트롤러 테스트 새글 제목")
				.param("content", "컨트롤러 테스트 새글 내용")
				.param("writer", "컨트롤러 테스트 저자"))
				.andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
	
	//@Test
	public void testGet() throws Exception{//218p
		log.info(mockMvc.perform(MockMvcRequestBuilders
				.get("/board/get")
				.param("bno", "31"))
				.andReturn()
				.getModelAndView().getModelMap());
	}
	
	//@Test
	public void testModify() throws Exception{//220p
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
				.param("bno", "31")
				.param("title", "컨트롤러 테스트 수정된 제목")
				.param("content", "컨트롤러 테스트 수정된 내용")
				.param("writer", "컨트롤러 테스트 수정된 저자"))
				.andReturn()
				.getModelAndView()
				.getViewName();
		log.info(resultPage);
	}
	
	//@Test
	public void testRemove() throws Exception{//221p
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
				.param("bno", "32"))
				.andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
	
	@Test
	public void testListPaging() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders
				.get("/board/list")
				.param("pageNum", "2")
				.param("amount", "50")));
	}
}
