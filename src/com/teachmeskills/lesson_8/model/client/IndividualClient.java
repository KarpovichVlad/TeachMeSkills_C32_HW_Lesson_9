package com.teachmeskills.lesson_8.model.client;

import com.teachmeskills.lesson_8.model.account.Account;
import com.teachmeskills.lesson_8.model.card.BaseCard;

public class IndividualClient  extends BaseClient{
    String passportNumber;

    public IndividualClient(String name, Account[] accounts, BaseCard[] cards, String passportNumber ){
        super(name, accounts, cards);
        this.passportNumber = passportNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Passport Number: " + passportNumber);
    }
}
