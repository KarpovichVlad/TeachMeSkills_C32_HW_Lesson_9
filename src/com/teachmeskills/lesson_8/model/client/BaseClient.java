package com.teachmeskills.lesson_8.model.client;

import com.teachmeskills.lesson_8.model.account.Account;
import com.teachmeskills.lesson_8.model.card.BaseCard;

public abstract class BaseClient {

    protected String name;
    protected Account[] accounts;
    protected BaseCard[] cards;

    public BaseClient(String name, Account[] accounts, BaseCard[] cards ){
        this.name = name;
        this.accounts = accounts;
        this.cards = cards;
    }
    public void showInfo() {
        System.out.println("Client Name: " + name);
        for (Account account : accounts) {
            System.out.println("Account: " + account.getAccountNumber() + ", Balance: " + account.getBalance());
        }
        for (BaseCard card : cards) {
            System.out.println("Card: " + card.getCardNumber() + ", Balance: " + card.getBalance());
        }
    }
}


