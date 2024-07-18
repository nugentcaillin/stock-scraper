package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @GetMapping("/{exchange}/{ticker}")
    public ResponseEntity<Stock> getPrices(
        @PathVariable(name="ticker") String ticker, 
        @PathVariable(name="exchange") String exchange) {

        Stock s = stockRepository.findByTickerAndExchange(ticker, exchange);

        return new ResponseEntity<>(s, HttpStatus.OK);
    }
}