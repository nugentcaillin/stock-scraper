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
        stock1.setTicker("ABCDEF");

        StockPrice price1 = new StockPrice();
        price1.setPrice(new BigDecimal(102));
        price1.setDate(LocalDate.of(2024, Month.JULY, 11));
        price1.setStock(stock1);

        stock1.getPrices().add(price1);

        stockRepository.save(stock1);
    }

    public void delete() {
        stockRepository.deleteAll();
    }
}