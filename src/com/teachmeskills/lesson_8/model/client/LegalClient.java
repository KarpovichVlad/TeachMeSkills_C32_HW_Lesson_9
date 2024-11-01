package com.teachmeskills.lesson_8.model.client;

import com.teachmeskills.lesson_8.model.account.Account;
import com.teachmeskills.lesson_8.model.card.BaseCard;

public class LegalClient extends BaseClient{
    String legalClientNumber;

    public LegalClient(String name, Account[] accounts, BaseCard[] cards, String legalClientNumber ){
        super(name, accounts, cards);
        this.legalClientNumber = legalClientNumber;
    }

    public String getLegalClientNumber() {
        return legalClientNumber;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Legal Client Number: " + legalClientNumber);
    }
}
