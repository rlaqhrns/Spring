package com.green.test.domain;


import com.green.test.domain.Expense;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ExpensiveRepository extends CrudRepository<Expense, Long> {
    //방법 1) 멤버변수(칼럼명)으로 자동 생성하는 메서드
    public List<Expense> findByItem(String item);

    //방법 2) Query문을 이용하여 사용자가 임의로 정하는 메서드
    @Query("SELECT e FROM Expense e WHERE e.amount >= :amount")
    public List<Expense> listItemWithPriceOver(@Param("amount") float amount); //@Param은 칼럼명이 다를때 Mapping해주는 역할
}
