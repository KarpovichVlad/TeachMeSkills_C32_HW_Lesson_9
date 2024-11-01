package com.teachmeskills.lesson_8;

import com.teachmeskills.lesson_8.document_parser.IParser;
import com.teachmeskills.lesson_8.fabric.ParserFabric;
import com.teachmeskills.lesson_8.model.account.Account;
import com.teachmeskills.lesson_8.model.card.BaseCard;
import com.teachmeskills.lesson_8.model.card.MasterCard;
import com.teachmeskills.lesson_8.model.card.VisaCard;
import com.teachmeskills.lesson_8.model.client.IndividualClient;
import com.teachmeskills.lesson_8.model.client.LegalClient;
import com.teachmeskills.lesson_8.model.document.Check;
import com.teachmeskills.lesson_8.transfer.impl.MasterCardTransferService;
import com.teachmeskills.lesson_8.transfer.impl.VisaCardTransferService;

import java.util.Scanner;
import java.util.Date;

public class ApplicationRunner {

    public static void main(String[] args) {
        // TODO запросить с консоли путь и имя файла
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        // TODO сделать метод createParser статичным и избавиться от необходимости создания объекта parserFabric
        IParser parser = ParserFabric.createParser(fileName);

        // TODO заменить "" на имя файла, полученное со сканера
        parser.parseFile(fileName);

        // TODO реализовать тестовый сценарий
        // создать двух клиентов
        Account account1 = new Account("123456", 1000);
        Account account2 = new Account("789012", 2000);

        BaseCard visaCard = new VisaCard("4000123456789010", 123, new Date(), "Ivan Ivanov", "USD", 1500, 5);
        BaseCard masterCard = new MasterCard("5000123456789011", 456, new Date(), "Petr Petrov", "EUR", 3000, "Russia");

        // каждому клиенту создать два счета и две карты
        IndividualClient individualClient = new IndividualClient("Ivan ", new Account[]{account1}, new BaseCard[]{visaCard}, "AB1234567");
        LegalClient legalClient = new LegalClient("Petr", new Account[]{account2}, new BaseCard[]{masterCard}, "LC789012");
        // перевести с карты одного клиента на карту другого сумму денег
        MasterCardTransferService masterCardTransferService = new MasterCardTransferService();
        VisaCardTransferService visaCardTransferService = new VisaCardTransferService();

        Check check1 = masterCardTransferService.transferFromCardToCard(masterCard, visaCard, 200);
        check1.showCheckInfo();

        // перевести с карты одного клинента на счет другого клиента сумму денег
        Check check2 = visaCardTransferService.transferFromCardToAccount(visaCard, account2.getAccountNumber(), 300);
        check2.showCheckInfo();

        individualClient.showInfo();
        legalClient.showInfo();
    }

}
