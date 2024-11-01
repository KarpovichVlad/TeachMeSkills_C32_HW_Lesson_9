package com.teachmeskills.lesson_8.transfer.impl;

import com.teachmeskills.lesson_8.model.card.BaseCard;
import com.teachmeskills.lesson_8.model.document.Check;
import com.teachmeskills.lesson_8.transfer.CardTransferService;

import java.util.Date;

// TODO реализовать имплементацию интерфейса
public class MasterCardTransferService implements CardTransferService {

    @Override
    public Check transferFromCardToCard(BaseCard fromCard, BaseCard toCard, double amount) {

        if (amount < 0) {
            return new Check(amount, new Date(), toCard.getCardNumber(), "Amount cannot be negative.");
        }
        if (fromCard.checkCardLimitTransfer(amount)) {
            fromCard.balance -= amount;
            toCard.balance += amount;
            return new Check(amount, new Date(), toCard.getCardNumber(),"Transfer successful.");
        }
        return new Check(amount, new Date(), toCard.getCardNumber(), "Transfer limit exceeded.");
    }

    @Override
    public Check transferFromCardToAccount(BaseCard fromCard, String toAccount, double amount) {

        if (amount < 0) {
            return new Check(amount, new Date(), toAccount, "Amount cannot be negative.");
        }
        if (fromCard.checkCardLimitTransfer(amount)) {
            fromCard.balance -= amount;
            return new Check(amount, new Date(), toAccount, "Transfer successful.");
        }
        return new Check(amount, new Date(),toAccount, "Transfer limit exceeded.");
    }
}


