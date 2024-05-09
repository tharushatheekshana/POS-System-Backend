package com.ijse.coursework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.coursework.dto.StockDto;
import com.ijse.coursework.entity.Category;
import com.ijse.coursework.entity.Stock;
import com.ijse.coursework.entity.StockCategory;
import com.ijse.coursework.service.StockCategoryService;
import com.ijse.coursework.service.StockService;

@RestController
@CrossOrigin(origins = "*")
public class StockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private StockCategoryService StockCategoryService;

    @PostMapping("/stocks")
    public ResponseEntity<Stock> addStock(@RequestBody StockDto stockDto) {
        StockCategory stockCategory = StockCategoryService.getStockCategoryById(stockDto.getStockCategoryId());
        Stock stock = new Stock();
        stock.setName(stockDto.getName());
        stock.setDescription(stockDto.getDescription());
        stock.setQuantity(stockDto.getQuantity());
        stock.setStockCategory(stockCategory);

        Stock addStock = stockService.addStock(stock);
        return ResponseEntity.status(201).body(addStock);
    }

    @GetMapping("/stocks")
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/stocks/{id}")
    public Stock getStockById(@PathVariable Long id) {
        return stockService.getStockById(id);
    }

    @PutMapping("/stocks/{id}")
    public Stock updateStock(@PathVariable Long id, @RequestBody Stock stock) {
        return stockService.updateStock(id, stock);
    }

    @DeleteMapping("/stocks/{id}")
    public void deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
    }

}
