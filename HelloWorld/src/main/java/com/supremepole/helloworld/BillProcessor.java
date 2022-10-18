package com.supremepole.helloworld;

import org.springframework.batch.item.ItemProcessor;

public class BillProcessor implements ItemProcessor<Bill, Bill> {

    public Bill process(Bill bill) {
        System.out.println(bill.toString());
        return bill;
    }

}
