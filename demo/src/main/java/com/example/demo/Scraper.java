package com.example.demo;

import java.util.ArrayList;

public interface Scraper {
    Stock getStockSummary(String ticker);
    StockPrice getDailyPrice(Stock stock);
    ArrayList<StockPrice> getPriceHistory(Stock ticker);
}