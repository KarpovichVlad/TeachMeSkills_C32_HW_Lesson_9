package com.teachmeskills.lesson_8.model.document;

import java.util.Date;

// TODO добавить поля на свое усмотрение
public class Invoice {
    private double amount;
    private Date date;
    private String accountNumber;

    public Invoice(double amount, Date date, String accountNumber) {
        this.amount = amount;
        this.date = date;
        this.accountNumber = accountNumber;
    }

    public void showInvoiceInfo() {
        System.out.println("Invoice - Amount: " + amount + ", Date: " + date + ", Account: " + accountNumber);
    }
}

