package com.example.demo;



import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StockPrice {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @JsonBackReference
    private Long stockId;

    private BigDecimal price;

    private LocalDate date;

    public Long getId() {
        return id;
    }

    public Long getStockId() {
        return stockId;
    }

    public BigDecimal getPrice() {
        return price;
    }
    
    public LocalDate getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}