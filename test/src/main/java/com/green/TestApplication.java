package com.green;

import com.green.test.domain.Expense;
import com.green.test.domain.ExpensiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import java.util.List;

@SpringBootApplication
@ComponentScan({"com.green"}) // 찾는 경로 지정
public class TestApplication implements CommandLineRunner {

	@Autowired
	ExpensiveRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
	@Override //한글깨지므로 영문으로 변경
	public void run(String... args) throws Exception {
		repository.save(new Expense("Breakfast", 5));
		repository.save(new Expense("Coffee",2));
		repository.save(new Expense("new SSD drive",200));
		repository.save(new Expense("Tuition",350));
		repository.save(new Expense("Apple",5));
		Iterable<Expense> iterator = repository.findAll();
		List<Expense> array = (List<Expense>)repository.findAll();
		System.out.println("총 항목의 비용은 : ");

		iterator.forEach(item-> System.out.println(item));
		List<Expense> breakfast = repository.findByItem("breakfast");
		System.out.println("\n 내 아침식사 비용은 얼마인가? ");
		breakfast.forEach(item-> System.out.println(item));

		List<Expense> expensiveItems = repository.listItemWithPriceOver(200);
		System.out.println("\n 값비싼 항목은 " );
		expensiveItems.forEach(item-> System.out.println(item));

	}
}
