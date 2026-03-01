package com.example.store.Controller.stockMangment;


import com.example.store.Model.StockMangement.Stock;
import com.example.store.Service.stockManagment.StockService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @PostMapping("/stocks")
    public ResponseEntity<Stock> saveStock(@Valid @RequestBody Stock stock){
        Stock return_stock =stockService.saveStock(stock);
        return  ResponseEntity.ok(return_stock);
    }

    @GetMapping("/stocks")
    public ResponseEntity < List<Stock> > fetchStockList(){
        List<Stock> stock_list =stockService.fetchStockList();;
        return ResponseEntity.ok(stock_list);
    }

    @DeleteMapping("/stocks/{id}")
    public ResponseEntity<String> deleteStockById(@PathVariable("id") Long stockId){
        stockService.deleteStockById(stockId);
        return ResponseEntity.ok("Deleted Successfully");
    }
    @GetMapping("/stocks/find/{id}")
    public ResponseEntity<Stock> findStockById(@PathVariable("id") Long stockId){
        Stock stock =stockService.findStockById(stockId);
        return ResponseEntity.ok(stock);
    }

}
