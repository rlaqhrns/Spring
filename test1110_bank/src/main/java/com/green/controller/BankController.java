package com.green.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.service.BankService;
import com.green.vo.CustomerVO;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
@RequestMapping("/bank/*")
@AllArgsConstructor
public class BankController {
	private BankService service;
	@RequestMapping("/list")
	public void list(CustomerVO cus, Model model) {
		List<CustomerVO> list = service.getList();
		
//		list.forEach(i->i.setBooleanLoan());
//		list.forEach(i->log.info("service.getList()"+ i.getBooleanLoan() ));
		model.addAttribute("bankTransaction", list);
		
		
	}
	@PostMapping("/register")//216p post방식은 form 태그 사용
	public String register(CustomerVO cus, RedirectAttributes rttr) {
		
		service.register(cus);
		return "redirect:/bank/list";//response.sendRedirect 호출
	}
	@GetMapping("/register")//216p
	public String register1() {//board 폴더 1.jsp
		
		return "/bank/register";
	}
	@GetMapping({"/get", "/modify"})//218p, 중괄호 259p
	public void get(@RequestParam("cus_id") int cus_id, Model model) {
		model.addAttribute("bankTransaction", service.get(cus_id));
	}
	@PostMapping("/modify")//216p post방식은 form 태그 사용
	public String modify(CustomerVO cus, RedirectAttributes rttr) {
		
		service.modify(cus);
		return "redirect:/bank/list";//response.sendRedirect 호출
	}
	@PostMapping("/remove")//post 방식의 삭제
	public String remove(@RequestParam("cus_id") int cus_id, RedirectAttributes rttr) {
		service.remove(cus_id);
		return "redirect:/bank/list";
	}
	@GetMapping("/bankTransaction")
	public void bankTransaction(@RequestParam("cus_id") int cus_id, Model model) {
		
		model.addAttribute("bankTransaction", service.get(cus_id));
		
	}
	@PostMapping("/bankTransaction")
	public String bankTransaction(CustomerVO cus, RedirectAttributes rttr) {
		service.bankTransaction(cus);
		
		System.out.println("이거 안나오면 모른 " + service.get(cus.getCus_id()).getBalance());
		return "redirect:/bank/list";
		
	}
	
}
