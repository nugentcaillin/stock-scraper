package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StockRepository extends CrudRepository<Stock, Long> {
    @Query(value="SELECT * FROM stock WHERE ticker = :ticker AND exchange = :exchange LIMIT 1", nativeQuery=true)
    Stock findByTickerAndExchange(@Param("ticker") String ticker, @Param("exchange") String exchange);
}