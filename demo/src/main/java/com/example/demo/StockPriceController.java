package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/price")
public class StockPriceController {

    @Autowired
    private StockPriceRepository stockPriceRepository;


    @GetMapping("/{exchange}/{ticker}")
    public ResponseEntity<List<StockPrice>> getPriceByExchangeTickerAndDate(
        @PathVariable(value="exchange") String exchange,
        @PathVariable(value="ticker") String ticker,
        @RequestParam @DateTimeFormat(iso=ISO.DATE) Date startDate,
        @RequestParam @DateTimeFormat(iso=ISO.DATE) Date endDate) {
        
        List<StockPrice> prices = stockPriceRepository.findStockByTickerExchangeStartDateEndDate(ticker, exchange, startDate, endDate);

        return new ResponseEntity<>(prices, HttpStatus.OK);
    }
}