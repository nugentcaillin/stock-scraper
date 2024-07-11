package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String ticker;

    @JsonManagedReference
    @OneToMany(mappedBy="stock", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<StockPrice> prices = new ArrayList<StockPrice>();


    public Long getId() {
        return id;
    }

    public List<StockPrice> getPrices() {
        return prices;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setId(Long id) {
        this.id = id;
    }
}