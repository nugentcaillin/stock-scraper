package com.example.demo;



import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class StockPrice {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="stock_id")
    private Stock stock;

    private BigDecimal price;

    private LocalDate date;

    public Long getId() {
        return id;
    }

    public Stock getStock() {
        return stock;
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

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}