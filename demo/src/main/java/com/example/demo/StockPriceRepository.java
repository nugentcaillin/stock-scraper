package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface StockPriceRepository extends CrudRepository<StockPrice, Long> {
    // the first of many janky one line queries
    @Query(value="SELECT stock_price.id, stock_price.date, stock_price.price, stock_price.stock_id FROM stock_price INNER JOIN stock ON stock_price.stock_id = stock.id WHERE ticker = :ticker AND exchange = :exchange AND date <= date(:endDate) AND date >= date(:startDate)", nativeQuery=true)
    List<StockPrice> findStockByTickerExchangeStartDateEndDate(@Param("ticker") String ticker, 
    @Param("exchange") String exchange, 
    @Param("startDate") Date startDate,
    @Param("endDate") Date endDate);
}