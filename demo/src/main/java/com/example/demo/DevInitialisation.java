package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
@Profile("dev")
public class DevInitialisation implements CommandLineRunner {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public void run(String... args) {
        delete();
        System.out.println("Database deleted");
        populate();
        System.out.println("Database populated");
    }

    public void populate() {
        Stock stock1 = new Stock();
        stock1.setTicker("ABCDEFG");
        stock1.setExchange("ASX");

        StockPrice price1 = new StockPrice();
        price1.setPrice(new BigDecimal(102));
        price1.setDate(LocalDate.of(2024, Month.JULY, 11));
        price1.setStock(stock1);

        StockPrice price2 = new StockPrice();
        price2.setPrice(new BigDecimal(102));
        price2.setDate(LocalDate.of(2024, Month.JUNE, 11));
        price2.setStock(stock1);

        StockPrice price3 = new StockPrice();
        price3.setPrice(new BigDecimal(102));
        price3.setDate(LocalDate.of(2024, Month.MAY, 11));
        price3.setStock(stock1);


        stock1.getPrices().add(price1);
        stock1.getPrices().add(price2);
        stock1.getPrices().add(price3);

        stockRepository.save(stock1);
    }

    public void delete() {
        stockRepository.deleteAll();
    }
}