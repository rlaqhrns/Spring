package com.green.test.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //테이블 생성
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String item;
    private float amount;

    public Expense(){
    } // 생성자

    public Expense(String item, float amount){
        this.item = item;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return id+ " ," + item +" - " + amount+ " USD";
    }
}
