package com.green.test.controller;

import com.green.TestApplication;
import com.green.test.domain.Expense;
import com.green.test.domain.ExpensiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class BoardController {

    @Autowired
    ExpensiveRepository repository;
    @GetMapping("/")
    public String ab() {
        System.out.println("총 항목의 비용은 : ");

        repository.save(new Expense("아침 식사", 5));
        repository.save(new Expense("커피",2));
        repository.save(new Expense("새로운 SSD 드라이브",200));
        repository.save(new Expense("아가용 Tuition",350));
        repository.save(new Expense("사과 뭉치",5));

        Iterable<Expense> iterator = repository.findAll();
        //List<Expense> array = (List<Expense>)repository.findAll();

        iterator.forEach(item-> System.out.println(item));
        List<Expense> breakfast = repository.findByItem("아침 식사");
        System.out.println("\n 내 아침식사 비용은 얼마인가? ");
        breakfast.forEach(item-> System.out.println(item));

        List<Expense> expensiveItems = repository.listItemWithPriceOver(200);
        System.out.println("\n 값비싼 항목은 " );
        expensiveItems.forEach(item-> System.out.println(item));
        return "z.html";
    }
}