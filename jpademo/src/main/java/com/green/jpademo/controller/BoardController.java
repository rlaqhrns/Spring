package com.green.jpademo.controller;

import com.green.jpademo.dto.BoardDto;
import com.green.jpademo.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class BoardController {

    private BoardService boardService;
    public BoardController(BoardService boardService) {this.boardService=boardService;}
    @GetMapping("/")
    public String list(Model model){
        return "board/list.html";
    }

    @GetMapping("/post")
    public  String post() {
        return "board/post.html";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "redirect:/";

    }

    @GetMapping("/post/{id}")
    public String detail(@PathVariable("id") Long id, Model model){
        BoardDto boardDto = boardService.getPost(id);
        model.addAttribute("post", boardDto);
        return "board/detail.html";
    }
    @GetMapping("/post/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        BoardDto boardDto = boardService.getPost(id);
        model.addAttribute("post",boardDto);
        return "board/edit.html";
    }
    @PutMapping("/post/edit/{id}")
    public String update(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "redirect:/";
    }
    public String delete(@PathVariable("id") Long id){
        boardService.deletePost(id);
        return "redirect:/";
    }
}
