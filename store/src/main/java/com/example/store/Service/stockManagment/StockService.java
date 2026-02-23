package com.example.store.Service.stockManagment;

import com.example.store.Model.StockMangement.Stock;

import java.util.List;

public interface StockService {

    Stock saveStock(Stock stock);

    List<Stock> fetchStockList();

    void deleteStockById(Long stockId);

    Stock findStockById(Long Stock);
}
