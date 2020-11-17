package com.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.domain.BoardVO;
import com.green.domain.Criteria;
import com.green.domain.PageDTO;
import com.green.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/board/*")
@Slf4j
@AllArgsConstructor
public class BoardController {

	   private BoardService service;
	   
	   
	   @GetMapping("/list")
	   public void list(Model model, Criteria cri) {
	      log.info("��Ʈ�ѷ����� list");
	      model.addAttribute("list", service.getList(cri));
	      //model.addAttribute("pageMaker", new PageDTO(cri,123)); 
	      
	      int total = service.getTotal(cri);
	      log.info("total :" + total);
	      model.addAttribute("pageMaker", new PageDTO(cri, total)); // �˻��ϴ� �� 
	      
	   }
	   
	   @PostMapping("/register")
	   public String register(BoardVO board, RedirectAttributes rttr) {
		  
		   
		   service.register(board);
		   
		   rttr.addFlashAttribute("result", board.getBno());
		   log.info("register : " + board);
		   
		   return "redirect:/board/list";
	   }
	   
	   @GetMapping("/register")
	   public String register() {
		   
		   
		   return "/board/register";
	   }
	   
	   @GetMapping({"/get", "/modify"})
	   public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		   log.info("��Ʈ�ѷ��� /get or /modify");
		   model.addAttribute("board", service.get(bno));
	   }
	   

	   @PostMapping("/modify")
	   public String modify(BoardVO board, RedirectAttributes rttr, @ModelAttribute("cri") Criteria cri) {
		   log.info("modify : " + board.getContent());
		   
		   if(service.modify(board)) {
			   rttr.addFlashAttribute("result", "success");
		   }
		   
		   rttr.addAttribute("pageNum", cri.getPageNum());
		   rttr.addAttribute("amount", cri.getAmount());
		   
		   return "redirect:/board/list";
	   }
	   
	   @PostMapping("/remove")
	   public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		   log.info("remove..." + bno);
		   if(service.remove(bno)) {
			   rttr.addFlashAttribute("result", "success");
		   }
		   rttr.addAttribute("pageNum", cri.getPageNum());
		   rttr.addAttribute("amount", cri.getAmount());
		   
		   return "redirect:/board/list";
	   }
	
}
