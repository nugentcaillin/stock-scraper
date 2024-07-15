package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @GetMapping
    public ResponseEntity<Stock> getPrices(
        @RequestParam String ticker, 
        @RequestParam String exchange) {

        Stock s = stockRepository.findByTickerAndExchange(ticker, exchange);

        return new ResponseEntity<>(s, HttpStatus.OK);
    }
}